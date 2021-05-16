package org.dogadaev.navigation

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val navigationModule = module {
    single<Navigator>(createdAtStart = true) { NavigatorImpl(androidApplication()) }
}