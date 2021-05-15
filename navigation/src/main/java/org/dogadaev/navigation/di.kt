package org.dogadaev.navigation

import org.koin.dsl.module

val navigationModule = module {
    single { Navigator() }
}