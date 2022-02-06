plugins {
    with(build.plugin) {
        id(androidLibrary)
    }
}

android {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjvm-default=compatibility")
    }
}

dependencies {
    with(build.project) {
        implementation(project(common_entity))
        implementation(project(interactor))
    }

    with(build.deps) {
        api(appcompat)

        implementation(lifecycleCommon)
        implementation(lifecycleRuntime)

        implementation(viewmodel)
        implementation(livedata)
    }
}