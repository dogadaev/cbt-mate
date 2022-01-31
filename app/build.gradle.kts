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
    implementation(project(":common:entity"))
    implementation(project(":interactor"))
    implementation(project(":presentation"))
    implementation(project(":navigation"))

    implementation(project(":framework:database"))
    implementation(project(":framework:repository"))

    implementation(project(":common:ui"))
    implementation(project(":feature:home"))
    implementation(project(":feature:diary"))
    implementation(project(":feature:diary-creation-form"))
}