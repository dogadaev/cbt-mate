package org.dogadaev.database

import androidx.room.Database
import androidx.room.RoomDatabase
import org.dogadaev.database.dao.DairiesDao
import org.dogadaev.database.entity.DairyDB

@Database(entities = [DairyDB::class], version = 1)
abstract class ApplicationDatabase: RoomDatabase() {
    abstract fun dairiesDao(): DairiesDao
}