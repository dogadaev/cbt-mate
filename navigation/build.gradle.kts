plugins {
    with(build.plugin) {
        id(androidLibrary)
        id(safeArgs)
    }
}

dependencies {
    api(build.deps.navigationFragment)
    api(build.deps.navigationUI)
}