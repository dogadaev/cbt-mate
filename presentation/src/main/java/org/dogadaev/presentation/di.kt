package org.dogadaev.presentation

import org.dogadaev.presentation.viewmodel.DiaryViewModel
import org.dogadaev.presentation.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val presentationModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { params -> DiaryViewModel(get { params }) }
}