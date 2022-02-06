package org.dogadaev.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.dogadaev.entity.Diary
import org.dogadaev.interactor.usecase.DiaryCreationUseCase
import org.dogadaev.interactor.usecase.HomeUseCase
import java.lang.System.currentTimeMillis
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: HomeUseCase,
    private val diaryCreationUseCase: DiaryCreationUseCase
) : ViewModel() {
    private val _data = MutableStateFlow<List<Diary>>(emptyList())
    val data = _data.asStateFlow()

    init {
        viewModelScope.launch {
            diaryCreationUseCase.saveDairy(
                Diary(
                    "ID,",
                    "ID,",
                    "ID,",
                    currentTimeMillis(),
                    emptyList(),
                )
            )
        }

        viewModelScope.launch {
            useCase.diaries.collect {
                _data.emit(it)
            }
        }
    }

    fun removeTestItem(diary: Diary) {
        viewModelScope.launch {
            useCase.removeDairy(diary)
        }
    }

    fun insertTestItem(diary: Diary) {

    }
}