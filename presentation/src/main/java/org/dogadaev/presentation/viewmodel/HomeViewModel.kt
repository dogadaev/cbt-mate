package org.dogadaev.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.dogadaev.entity.Diary
import org.dogadaev.interactor.usecase.HomeUseCase
import java.lang.System.currentTimeMillis
import java.util.*

class HomeViewModel(
    private val useCase: HomeUseCase
) : ViewModel() {
    val data = MutableLiveData<List<Diary>>(emptyList())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.getDairiesFlow().collect {
                data.postValue(it)
            }
        }
    }

    fun removeTestItem(diary: Diary) {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.removeDairy(diary)
        }
    }
}