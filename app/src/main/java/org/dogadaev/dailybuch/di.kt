package org.dogadaev.dailybuch

import org.dogadaev.repository.repositoryModule
import org.dogadaev.database.databaseModule
import org.dogadaev.diary.diaryModule
import org.dogadaev.entity.entityModule
import org.dogadaev.home.homeModule
import org.dogadaev.interactor.interactorModule
import org.dogadaev.navigation.navigationModule
import org.dogadaev.presentation.presentationModule
import org.dogadaev.ui.commonUiModule
import org.koin.dsl.module

private val appModule = module {

}

private val uiModules = listOf(
    commonUiModule,
    homeModule,
    diaryModule
)

private val frameWorkModules = listOf(
    entityModule,
    navigationModule,
    interactorModule,
    databaseModule,
    repositoryModule,
    presentationModule,
)

val koinModules = appModule + uiModules + frameWorkModules
