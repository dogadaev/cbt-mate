package org.dogadaev.interactor.repository

import kotlinx.coroutines.flow.Flow
import org.dogadaev.entity.Diary

interface DairyRepository {
    fun getDairiesFlow(): Flow<List<Diary>>
    fun saveDairy(diary: Diary)
    fun removeDairy(diary: Diary)
}