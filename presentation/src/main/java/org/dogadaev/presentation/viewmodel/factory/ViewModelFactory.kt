package org.dogadaev.presentation.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.dogadaev.entity.ViewModelPayload
import org.dogadaev.presentation.viewmodel.DiaryViewModel

class ViewModelFactory(
    private val assistedFactory: AssistedViewModelFactory,
    private val payload: ViewModelPayload = object : ViewModelPayload {}
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>) = when (modelClass) {
        DiaryViewModel::javaClass -> assistedFactory.createDiaryViewModel(
            diaryId = (payload as DiaryViewModel.Payload).diaryId
        )
        else -> throw IllegalStateException()
    } as T
}