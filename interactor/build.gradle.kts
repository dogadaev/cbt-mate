plugins {
    with(build.plugin) {
        id(androidLibrary)
    }
}

dependencies {
    implementation(project(":common:entity"))
    implementation(build.deps.coroutines)
}