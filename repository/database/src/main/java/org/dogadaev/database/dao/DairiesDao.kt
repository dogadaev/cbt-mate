package org.dogadaev.database.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import org.dogadaev.database.entity.DiaryDB
import org.dogadaev.database.entity.DiaryWithEntries

@Dao
interface DairiesDao {

    @Query("SELECT * FROM diarydb")
    fun getDairiesWithEntries(): Flow<List<DiaryWithEntries>>

    @Query("SELECT * FROM diarydb")
    fun getDairies(): Flow<List<DiaryDB>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveDairies(vararg diaries: DiaryDB)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveEntry(vararg entry: DiaryDB.Entry)

    @Delete
    fun delete(diary: DiaryDB)
}