plugins {
    with(build.plugin) {
        id(androidLibrary)
    }
}

dependencies {
    with(build.project) {
        implementation(project(common_entity))
    }

    with(build.deps) {
        implementation(coroutines)
    }
}