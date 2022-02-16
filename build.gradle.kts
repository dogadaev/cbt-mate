import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryPlugin

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(build.deps.gradle)
        classpath(build.deps.kotlinPlugin)
        classpath(build.deps.navigationSafeArgs)
        classpath(build.deps.hilt.plugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks {
    register("clean", Delete::class.java) {
        delete(rootProject.buildDir)
    }
}

subprojects {
    val applicationConfig: Any.() -> Unit = {
        extensions.configure<com.android.build.gradle.AppExtension> {
            with(build.plugin) {
                apply(plugin = kotlinAndroid)
                apply(plugin = kapt)
                apply(plugin = hilt)
            }

            defaultConfig {
                minSdk = build.version.minSdk
                targetSdk = build.version.targetSdk
                compileSdkVersion(build.version.compileSdk)
            }

            buildFeatures.apply {
                viewBinding = true
                buildConfig = false
                compose = true
            }

            composeOptions {
                kotlinCompilerExtensionVersion = build.version.compose
            }

            repositories {
                mavenCentral()
            }

            buildTypes {
                getByName("release") {
                    isMinifyEnabled = true
                    isDebuggable = false
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }

                getByName("debug") {
                    isMinifyEnabled = false
                    isDebuggable = true
                }
            }

            dependencies {
                add("implementation", build.deps.hilt.android)
                add("kapt", build.deps.hilt.compiler)

                add("implementation", build.deps.kotlin)

//                add("testImplementation", build.deps.junit)
//                add("androidTestImplementation", build.deps.junitExt)
            }
        }

        tasks.withType<Test> {
            useJUnitPlatform()
        }
    }

    val libraryConfig: Any.() -> Unit = {
        extensions.configure<com.android.build.gradle.LibraryExtension> {
            with(build.plugin) {
                apply(plugin = kotlinAndroid)
                apply(plugin = kapt)
                apply(plugin = hilt)
            }

            defaultConfig {
                minSdk = build.version.minSdk
                compileSdk = build.version.compileSdk
            }

            buildFeatures.apply {
                viewBinding = true
                buildConfig = false
            }

            dependencies {
                add("implementation", build.deps.hilt.android)
                add("kapt", build.deps.hilt.compiler)

                add("implementation", build.deps.kotlin)
            }
        }
    }

    plugins.withType<LibraryPlugin>(libraryConfig)
    plugins.withType<AppPlugin>(applicationConfig)
}