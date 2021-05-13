package org.dogadaev.dairy

import org.dogadaev.interactor.repository.DiaryRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<DiaryRepository> { DiaryRepositoryImpl(get()) }
}