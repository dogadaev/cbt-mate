plugins {
    with(build.plugin) {
        id(application)
    }
}

android {
    defaultConfig {
        applicationId = build.config.applicationId

        versionCode = build.config.versionCode
        versionName = build.config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    with(build.project) {
        implementation(project(interactor))
        implementation(project(presentation))
        implementation(project(navigation))

        implementation(project(common_ui))
        implementation(project(common_entity))

        implementation(project(framework_database))
        implementation(project(framework_repository))

        implementation(project(feature_home))
        implementation(project(feature_diary))
        implementation(project(feature_diaryCreationForm))
    }
}