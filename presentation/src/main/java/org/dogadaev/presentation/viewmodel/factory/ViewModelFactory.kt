package org.dogadaev.presentation.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import org.dogadaev.entity.ViewModelPayload
import org.dogadaev.presentation.viewmodel.DiaryViewModel

class ViewModelFactory(
    private val assistedFactory: AssistedViewModelFactory
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return create(modelClass, CreationExtras.Empty)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras) = when (modelClass) {
        DiaryViewModel::javaClass -> assistedFactory.createDiaryViewModel(extras)
        else -> throw IllegalStateException()
    } as T
}