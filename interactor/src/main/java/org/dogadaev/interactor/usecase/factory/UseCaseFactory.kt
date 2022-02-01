package org.dogadaev.interactor.usecase.factory

import dagger.assisted.AssistedFactory
import org.dogadaev.interactor.usecase.DiaryUseCase

@AssistedFactory
interface UseCaseFactory {

    fun createDiaryUseCase(
        diaryId: String
    ): DiaryUseCase
}