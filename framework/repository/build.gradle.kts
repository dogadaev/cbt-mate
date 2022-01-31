plugins {
    with(build.plugin) {
        id(androidLibrary)
    }
}

dependencies {
    with(build.project) {
        implementation(project(common_entity))
        implementation(project(interactor))
        implementation(project(framework_database))
    }

    with(build.deps) {
        implementation(coroutines)
    }
}