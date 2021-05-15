package org.dogadaev.repository

import org.dogadaev.interactor.repository.DiaryRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<DiaryRepository> { DiaryRepositoryImpl(get()) }
}