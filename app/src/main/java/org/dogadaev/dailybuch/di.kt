package org.dogadaev.dailybuch

import org.dogadaev.repository.repositoryModule
import org.dogadaev.database.databaseModule
import org.dogadaev.entity.entityModule
import org.dogadaev.home.homeModule
import org.dogadaev.interactor.interactorModule
import org.dogadaev.navigation.navigationModule
import org.dogadaev.presentation.presentationModule
import org.dogadaev.ui.commonUiModule
import org.koin.dsl.module

private val appModule = module {

}

val koinModules = listOf(
    appModule,
    entityModule,
    interactorModule,
    presentationModule,
    databaseModule,
    repositoryModule,
    commonUiModule,
    homeModule,
    navigationModule
)