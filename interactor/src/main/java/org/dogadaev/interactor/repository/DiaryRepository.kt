package org.dogadaev.interactor.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import org.dogadaev.entity.Diary

interface DiaryRepository {
    val diaries: Flow<List<Diary>>

    suspend fun getDiaryFlow(diaryId: String): Flow<Diary>
    suspend fun getEntriesFlow(diaryId: String): Flow<List<Diary.Entry>>

    suspend fun saveDairy(diary: Diary)
    suspend fun saveEntry(entry: Diary.Entry)
    suspend fun removeDairy(diary: Diary)
}