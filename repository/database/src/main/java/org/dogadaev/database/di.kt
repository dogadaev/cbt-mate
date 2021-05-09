package org.dogadaev.database

import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication().applicationContext,
            ApplicationDatabase::class.java,
            "dairy-buch-database"
        ).build()
    }

    single { get<ApplicationDatabase>().dairiesDao() }
}