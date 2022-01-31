rootProject.buildFileName = "build.gradle.kts"
rootProject.name = "cbt-mate"

include(
    ":app",
    ":interactor",
    ":presentation",
    ":navigation",

    ":common:ui",
    ":common:entity",

    ":framework:database",
    ":framework:repository",

    ":feature:home",
    ":feature:diary",
    ":feature:diary-creation-form"
)