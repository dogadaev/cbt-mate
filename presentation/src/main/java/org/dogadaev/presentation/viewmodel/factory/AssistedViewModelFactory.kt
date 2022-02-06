package org.dogadaev.presentation.viewmodel.factory

import androidx.lifecycle.viewmodel.CreationExtras
import dagger.assisted.AssistedFactory
import org.dogadaev.presentation.viewmodel.DiaryViewModel

@AssistedFactory
interface AssistedViewModelFactory {

    fun createDiaryViewModel(
        extras: CreationExtras
    ): DiaryViewModel
}