package org.dogadaev.home.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import org.dogadaev.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    openDiary: (diaryId: String) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    Column {
        Toolbar(
            createDiary = {
                viewModel.insertTestItem()
            }
        )
        viewModel.data.collectAsState().value.let { diaries ->
            LazyColumn {
                items(diaries) { item ->
                    DiaryCard(
                        diary = item,
                        openDiary = {
                            openDiary(item.id)
                        },
                        removeItem = {
                            viewModel.removeItem(item)
                        }
                    )
                }
            }
        }
    }
}