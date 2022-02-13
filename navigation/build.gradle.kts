plugins {
    with(build.plugin) {
        id(androidLibrary)
        id(safeArgs)
    }
}

dependencies {
    with(build.deps) {
        api(navigationCompose)
    }
}