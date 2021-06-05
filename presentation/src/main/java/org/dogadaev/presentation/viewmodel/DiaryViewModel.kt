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
) : ViewModel() {

    val data = MutableLiveData<Diary>()
    val title = MutableLiveData<String>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.getDiary().collect {
                data.postValue(it)

                title.postValue(it.title)
            }
        }
    }

    fun insertTestEntry() {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.insertEntry()
        }
    }
}