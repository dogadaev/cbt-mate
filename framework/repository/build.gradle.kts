plugins {
    with(build.plugin) {
        id(androidLibrary)
    }
}

dependencies {
    implementation(project(":common:entity"))
    implementation(project(":interactor"))
    implementation(project(":framework:database"))

    implementation(build.deps.coroutines)
}