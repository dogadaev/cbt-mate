package org.dogadaev.presentation.viewmodel.factory

import dagger.assisted.AssistedFactory
import org.dogadaev.presentation.viewmodel.DiaryViewModel

@AssistedFactory
interface AssistedViewModelFactory {

    fun createDiaryViewModel(
        diaryId: String
    ): DiaryViewModel
}