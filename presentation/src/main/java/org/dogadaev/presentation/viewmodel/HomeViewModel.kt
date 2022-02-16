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
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: HomeUseCase,
    private val diaryCreationUseCase: DiaryCreationUseCase
) : ViewModel() {

    val data = useCase.diaries.stateIn(
        viewModelScope,
        SharingStarted.Lazily,
        initialValue = emptyList()
    )

    fun removeItem(diary: Diary) {
        viewModelScope.launch {
            useCase.removeDairy(diary)
        }
    }

    fun insertTestItem(
        title: String,
        description: String
    ) {
        viewModelScope.launch {
            val uuid = UUID.randomUUID().toString()

            diaryCreationUseCase.saveDairy(
                Diary(
                    id = uuid,
                    title = title,
                    description = description,
                    creationTimestamp = currentTimeMillis(),
                    lastModifiedTimestamp = 0,
                    entries = emptyList(),
                )
            )
        }
    }
}