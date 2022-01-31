plugins {
    with(build.plugin) {
        id(androidLibrary)
    }
}

dependencies {
    implementation(build.deps.gson)

    implementation(build.deps.roomRuntime)
    implementation(build.deps.roomKtx)
    kapt(build.deps.roomCompiler)
}