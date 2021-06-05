package org.dogadaev.interactor.usecase

import org.dogadaev.entity.Diary
import org.dogadaev.interactor.repository.DiaryRepository

class DiaryCreationUseCase(
    private val repository: DiaryRepository
) {

    fun saveDairy(diary: Diary) = repository.saveDairy(diary)
}