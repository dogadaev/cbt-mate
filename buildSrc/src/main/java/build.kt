object build {

    object config {
        const val applicationId = "org.dogadaev.cbtmate"
        const val versionCode = 1
        const val versionName = "0.0.1"
    }

    object version {
        const val gradle = "7.2.0-beta01"

        const val minSdk = 24
        const val targetSdk = 31
        const val compileSdk = 31
        const val buildTools = "31.0.0"

        const val java = "1.8"

        // Libraries
        const val kotlin = "1.6.10"
        const val ktx = "1.7.0"
        const val appcompat = "1.4.0"
        const val hilt = "2.40.5"
        const val navigation = "2.4.1"
        const val lifecycle = "2.5.0-alpha01"
        const val fragment = "1.4.1"
        const val coroutines = "1.5.2"
        const val gson = "2.8.8"

        const val compose = "1.1.0"

        const val material = "1.5.0"
        const val constraint = "2.0.4"

        const val room = "2.4.1"

        const val junit = "4.13.2"
        const val junitExt = "1.1.2"
        const val espresso = "3.3.0"
    }

    object plugin {
        const val application = "com.android.application"
        const val androidLibrary = "com.android.library"
        const val kotlinLibrary = "java-library"
        const val kotlinAndroid = "kotlin-android"
        const val safeArgs = "androidx.navigation.safeargs"
        const val kotlin = "kotlin"
        const val kapt = "kotlin-kapt"
        const val hilt = "dagger.hilt.android.plugin"
    }
    
    object deps {
        // Build system
        const val gradle = "com.android.tools.build:gradle:${version.gradle}"

        // Compiler
        const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${version.kotlin}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${version.kotlin}"
        const val kapt = "org.jetbrains.kotlin:kotlin-stdlib:${version.kotlin}"

        // Framework
        const val ktx = "androidx.core:core-ktx:${version.ktx}"
        const val appcompat = "androidx.appcompat:appcompat:${version.appcompat}"

        // Jetpack Compose
        const val compose = "androidx.compose.ui:ui:${version.compose}"
        const val composeCompiler = "androidx.compose.compiler:compiler:${version.compose}"
        const val composeTooling = "androidx.compose.ui:ui-tooling:${version.compose}"
        const val composeFoundation = "androidx.compose.foundation:foundation:${version.compose}"
        const val composeMaterial = "androidx.compose.material:material:${version.compose}"
        const val composeMaterialIcons = "androidx.compose.material:material-icons-extended:${version.compose}"
        const val composeActivity = "androidx.activity:activity-compose:1.4.0"
        const val composeLiveData = "androidx.compose.runtime:runtime-livedata:${version.compose}"
        const val composeHilt = "androidx.hilt:hilt-navigation-compose:1.0.0"
        const val composeTest = "androidx.compose.ui:ui-test-junit4:${version.compose}"

        // View
        const val constraint = "androidx.constraintlayout:constraintlayout:${version.constraint}"
        const val material = "com.google.android.material:material:${version.material}"

        // Navigation
        const val navigationSafeArgs =
            "androidx.navigation:navigation-safe-args-gradle-plugin:${version.navigation}"
        const val navigationCompose =
            "androidx.navigation:navigation-compose:${version.navigation}"

        // Lifecycle
        const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${version.lifecycle}"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime:${version.lifecycle}"
        const val lifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:${version.lifecycle}"
        const val livedata = "androidx.lifecycle:lifecycle-viewmodel-ktx:${version.lifecycle}"
        const val composeViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${version.lifecycle}"

        //Fragment
        const val fragment = "androidx.fragment:fragment:${version.fragment}"

        // Database
        const val roomRuntime = "androidx.room:room-runtime:${version.room}"
        const val roomCompiler = "androidx.room:room-compiler:${version.room}"
        const val roomKtx = "androidx.room:room-ktx:${version.room}"
        const val roomTest = "androidx.room:room-testing:${version.room}"

        // Serialization
        const val gson = "com.google.code.gson:gson:${version.gson}"

        // DI
        object hilt {
            const val plugin = "com.google.dagger:hilt-android-gradle-plugin:${version.hilt}"
            const val android = "com.google.dagger:hilt-android:${version.hilt}"
            const val compiler = "com.google.dagger:hilt-compiler:${version.hilt}"
        }

        // Coroutines
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${version.coroutines}"

        // Testing
        const val junit = "junit:junit:${version.junit}"
        const val junitExt = "androidx.test.ext:junit:${version.junitExt}"
        const val espresso = "androidx.test.espresso:espresso-core:${version.espresso}"
    }

    object project {
        const val app = ":app"
        const val interactor = ":interactor"
        const val presentation = ":presentation"
        const val navigation = ":navigation"
        const val common_ui = ":common:ui"
        const val common_entity = ":common:entity"
        const val framework_database = ":framework:database"
        const val framework_repository = ":framework:repository"
        const val feature_home = ":feature:home"
        const val feature_diary = ":feature:diary"
        const val feature_diaryCreationForm = ":feature:diary-creation-form"
    }
}