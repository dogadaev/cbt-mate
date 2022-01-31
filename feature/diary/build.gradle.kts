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
    with(build.project) {
        implementation(project(common_entity))
        implementation(project(common_ui))

        implementation(project(presentation))
        implementation(project(navigation))
    }
}
