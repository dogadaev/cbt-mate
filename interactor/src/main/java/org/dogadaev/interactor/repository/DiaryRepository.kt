package org.dogadaev.interactor.repository

import org.dogadaev.entity.Diary
import org.dogadaev.interactor.resource.ParametrizedResource
import org.dogadaev.interactor.resource.Resource

interface DiaryRepository {
    val diariesResource: Resource<List<Diary>>

    val diaryResource: ParametrizedResource<Diary, String>
    val entryResource: ParametrizedResource<List<Diary.Entry>, String>

    suspend fun saveDairy(diary: Diary)
    suspend fun saveEntry(entry: Diary.Entry)
    suspend fun removeDairy(diary: Diary)
}