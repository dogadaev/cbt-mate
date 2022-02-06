package org.dogadaev.interactor.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import org.dogadaev.entity.Diary
import org.dogadaev.interactor.resource.ParametrizedResource

interface DiaryRepository {
    val diaries: Flow<List<Diary>>

    val diaryResource: ParametrizedResource<Diary, String>
    val entryResource: ParametrizedResource<List<Diary.Entry>, String>

    suspend fun saveDairy(diary: Diary)
    suspend fun saveEntry(entry: Diary.Entry)
    suspend fun removeDairy(diary: Diary)
}