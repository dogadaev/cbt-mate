package org.dogadaev.interactor.repository

import kotlinx.coroutines.flow.Flow
import org.dogadaev.entity.Diary

interface DiaryRepository {
    fun getDiaryFlow(diaryId: String): Flow<Diary>
    fun getDairiesFlow(): Flow<List<Diary>>
    fun getEntriesFlow(diaryId: String): Flow<List<Diary.Entry>>

    fun saveDairy(diary: Diary)
    fun saveEntry(entry: Diary.Entry)
    fun removeDairy(diary: Diary)
}