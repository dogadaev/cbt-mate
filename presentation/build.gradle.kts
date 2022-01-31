plugins {
    with(build.plugin) {
        id(androidLibrary)
    }
}

dependencies {
    with(build.project) {
        implementation(project(common_entity))
        implementation(project(interactor))
    }

    with(build.deps) {
        implementation(viewmodel)
        implementation(livedata)
    }
}