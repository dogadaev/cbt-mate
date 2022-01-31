plugins {
    with(build.plugin) {
        id(androidLibrary)
        id(safeArgs)
    }
}

android {
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = build.version.compose
    }
}

dependencies {
    implementation(project(":common:entity"))
    implementation(project(":common:ui"))

    implementation(project(":presentation"))
    implementation(project(":navigation"))
}
