package org.dogadaev.dailybuch.application

import android.app.Application
import org.dogadaev.dailybuch.koinModules
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin

class DailyBuchApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            modules(koinModules)
            androidContext(applicationContext.applicationContext)
            fragmentFactory()
        }
    }
}