package org.dogadaev.database.di

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.dogadaev.database.ApplicationDatabase
import org.dogadaev.database.converter.EmotionConverter

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides fun provideDatabase(
        @ApplicationContext context: Context,
        gson: Gson
    ) = Room.databaseBuilder(
        context.applicationContext,
        ApplicationDatabase::class.java,
        "cbt-mate-database"
    )
        .addTypeConverter(
            EmotionConverter(gson)
        )
        .build()

    @Provides fun provideDiariesDao(
        database: ApplicationDatabase
    ) = database.dairiesDao()

    @Provides fun provideGson() = Gson()
}