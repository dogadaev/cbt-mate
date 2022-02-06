package org.dogadaev.database.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import org.dogadaev.database.entity.DiaryDB
import org.dogadaev.database.entity.DiaryWithEntries

@Dao
interface DiariesDao {

    val dairiesWithEntries: Flow<List<DiaryWithEntries>>
        @Query("SELECT * FROM diaries") get

    @Query("SELECT * FROM diaries WHERE id=:diaryId")
    fun getDairyFlow(diaryId: String): Flow<DiaryWithEntries>

    @Query("SELECT * FROM diary_entries WHERE diaryId=:diaryId")
    fun getDiaryEntries(diaryId: String): Flow<List<DiaryDB.Entry>>

    @Query("SELECT * FROM diaries")
    fun getDairies(): Flow<List<DiaryDB>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveDairies(vararg diaries: DiaryDB)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveEntry(vararg entry: DiaryDB.Entry)

    @Delete
    fun deleteDiary(diary: DiaryDB)

    @Query("DELETE FROM diary_entries WHERE diaryId=:diaryId")
    fun deleteEntries(diaryId: String)
}