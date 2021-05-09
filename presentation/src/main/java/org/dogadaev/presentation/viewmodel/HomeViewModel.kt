package org.dogadaev.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.dogadaev.entity.Dairy
import org.dogadaev.interactor.usecase.HomeUseCase
import java.util.*
import kotlin.random.Random

class HomeViewModel(
    private val useCase: HomeUseCase
) : ViewModel() {
    val data = MutableLiveData<List<Dairy>>(emptyList())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.getDairiesFlow().collect {
                data.postValue(it)
            }
        }
    }

    fun addTestItem() {
        viewModelScope.launch(Dispatchers.IO) {
            val id = UUID.randomUUID().toString()

            val testDairy = Dairy(
                id,
                id,
                "Очень длинное описание дневника. Текст нужен, чтоб протестировать карточку в реальных условиях.",
                "0"
            )
            useCase.saveDairy(testDairy)
        }
    }

    fun removeTestItem(dairy: Dairy) {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.removeDairy(dairy)
        }
    }
}