package org.dogadaev.interactor

import org.dogadaev.interactor.usecase.HomeUseCase
import org.koin.dsl.module

val interactorModule = module {
    factory { HomeUseCase(get()) }
}