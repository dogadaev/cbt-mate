plugins {
    with(build.plugin) {
        id(androidLibrary)
    }
}

dependencies {
    with(build.deps) {
        implementation(gson)

        implementation(roomRuntime)
        implementation(roomKtx)
    }

    /* Weird behaviour when applied within `with` function. */
    kapt(build.deps.roomCompiler)
}