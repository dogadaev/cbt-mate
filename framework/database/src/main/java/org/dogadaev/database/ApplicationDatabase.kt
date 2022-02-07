package org.dogadaev.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import org.dogadaev.database.converter.EmotionConverter
import org.dogadaev.database.dao.DiariesDao
import org.dogadaev.database.entity.DiaryDB
import javax.inject.Singleton

@Database(
    entities = [
        DiaryDB::class,
        DiaryDB.Entry::class,
    ],
    version = 1
)
@TypeConverters(
    value = [
        EmotionConverter::class
    ]
)
@Singleton
abstract class ApplicationDatabase : RoomDatabase() {
    abstract fun dairiesDao(): DiariesDao
}