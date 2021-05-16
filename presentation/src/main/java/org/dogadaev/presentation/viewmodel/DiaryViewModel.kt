package org.dogadaev.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.dogadaev.entity.Diary
import org.dogadaev.interactor.usecase.DiaryUseCase

class DiaryViewModel(
    private val useCase: DiaryUseCase,
): ViewModel() {
    val data =  MutableLiveData<List<Diary.Entry>>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.getEntries().collect {
                data.postValue(it)
            }
        }
    }

    fun insertTestEntry() {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.insertEntry()
        }
    }
}