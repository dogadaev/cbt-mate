plugins {
    with(build.plugin) {
        id(androidLibrary)
    }
}

android {
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = build.version.compose
    }
}

dependencies {
    with(build.deps) {
        api(compose)
        api(composeTooling)
        api(composeFoundation)
        api(composeMaterial)
        api(composeMaterialIcons)
        api(composeActivity)
        api(composeViewModel)
        api(composeLiveData)
        // api(composeTest)

        api(ktx)
        api(appcompat)

        api(material)
        api(constraint)

        implementation(lifecycleCommon)
        implementation(lifecycleRuntime)
        implementation(viewmodel)
        implementation(livedata)
    }
}