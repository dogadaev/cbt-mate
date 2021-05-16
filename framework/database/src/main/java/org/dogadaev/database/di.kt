package org.dogadaev.database

import androidx.room.Room
import com.google.gson.Gson
import org.dogadaev.database.converter.EmotionConverter
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication().applicationContext,
            ApplicationDatabase::class.java,
            "cbt-mate-database"
        )
            .addTypeConverter(EmotionConverter(get()))
            .build()
    }

    single { get<ApplicationDatabase>().dairiesDao() }

    single { Gson() }
}