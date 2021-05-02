package org.dogadaev.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.dogadaev.entity.Dairy
import org.dogadaev.interactor.usecase.HomeUseCase

class HomeViewModel(
    private val useCase: HomeUseCase
) : ViewModel() {

    val data = MutableLiveData<List<Dairy>>(emptyList())

    init {
    }

    fun addItem() {
    }
}