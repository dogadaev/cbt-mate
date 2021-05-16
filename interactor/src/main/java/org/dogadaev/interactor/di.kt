package org.dogadaev.interactor

import org.dogadaev.interactor.usecase.DiaryUseCase
import org.dogadaev.interactor.usecase.HomeUseCase
import org.koin.dsl.module

val interactorModule = module {
    factory { HomeUseCase(get()) }
    factory { (diaryId: String) -> DiaryUseCase(diaryId, get()) }
}