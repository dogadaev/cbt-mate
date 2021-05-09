package org.dogadaev.interactor.usecase

import kotlinx.coroutines.flow.Flow
import org.dogadaev.entity.Dairy
import org.dogadaev.interactor.repository.DairyRepository

class HomeUseCase(
    private val dairyRepository: DairyRepository
) {

    fun getDairiesFlow(): Flow<List<Dairy>> = dairyRepository.getDairiesFlow()
    fun saveDairy(dairy: Dairy) = dairyRepository.saveDairy(dairy)
    fun removeDairy(dairy: Dairy) = dairyRepository.removeDairy(dairy)
}