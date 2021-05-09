package org.dogadaev.dairy

import org.dogadaev.interactor.repository.DairyRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<DairyRepository> { DairyRepositoryImpl(get()) }
}