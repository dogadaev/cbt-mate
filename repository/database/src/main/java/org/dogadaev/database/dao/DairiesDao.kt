package org.dogadaev.database.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import org.dogadaev.database.entity.DiaryDB

@Dao
interface DairiesDao {

    @Query("SELECT * FROM dairydb")
    fun getDairies(): Flow<List<DiaryDB>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveDairies(vararg diaries: DiaryDB)

    @Delete
    fun delete(diary: DiaryDB)
}