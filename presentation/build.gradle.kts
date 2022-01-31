plugins {
    with(build.plugin) {
        id(androidLibrary)
    }
}

dependencies {
    implementation(project(":common:entity"))
    implementation(project(":interactor"))

    implementation(build.deps.viewmodel)
    implementation(build.deps.livedata)
}