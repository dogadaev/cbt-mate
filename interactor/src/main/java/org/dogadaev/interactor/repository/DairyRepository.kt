package org.dogadaev.interactor.repository

import kotlinx.coroutines.flow.Flow
import org.dogadaev.entity.Dairy

interface DairyRepository {
    fun getDairiesFlow(): Flow<List<Dairy>>
    fun saveDairy(dairy: Dairy)
    fun removeDairy(dairy: Dairy)
}