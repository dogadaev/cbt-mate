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
    api(build.deps.compose)
    api(build.deps.composeTooling)
    api(build.deps.composeFoundation)
    api(build.deps.composeMaterial)
    api(build.deps.composeMaterialIcons)
    api(build.deps.composeActivity)
    api(build.deps.composeViewModel)
    api(build.deps.composeLiveData)
    // api appDependencies.composeTest

    api(build.deps.ktx)
    api(build.deps.appcompat)

    api(build.deps.material)
    api(build.deps.constraint)

    implementation(build.deps.lifecycleCommon)
    implementation(build.deps.lifecycleRuntime)
    implementation(build.deps.viewmodel)
    implementation(build.deps.livedata)
}