package org.dogadaev.dailybuch

import org.dogadaev.common.commonModule
import org.dogadaev.entity.entityModule
import org.dogadaev.interactor.interactorModule
import org.dogadaev.repository.repositoryModule
import org.koin.dsl.module

private val appModule = module {

}

val koinModules = listOf(
    appModule,
    entityModule,
    repositoryModule,
    interactorModule,
    commonModule,
)