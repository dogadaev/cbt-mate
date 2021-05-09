package org.dogadaev.interactor.usecase

import kotlinx.coroutines.flow.Flow
import org.dogadaev.entity.Diary
import org.dogadaev.interactor.repository.DairyRepository

class HomeUseCase(
    private val dairyRepository: DairyRepository
) {

    fun getDairiesFlow(): Flow<List<Diary>> = dairyRepository.getDairiesFlow()
    fun saveDairy(diary: Diary) = dairyRepository.saveDairy(diary)
    fun removeDairy(diary: Diary) = dairyRepository.removeDairy(diary)
}