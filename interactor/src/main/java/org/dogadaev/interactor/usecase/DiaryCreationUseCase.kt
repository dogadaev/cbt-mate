package org.dogadaev.interactor.usecase

import org.dogadaev.entity.Diary
import org.dogadaev.interactor.repository.DiaryRepository
import javax.inject.Inject

class DiaryCreationUseCase @Inject constructor(
    private val repository: DiaryRepository
) {

    suspend fun saveDairy(diary: Diary) = repository.saveDairy(diary)
}