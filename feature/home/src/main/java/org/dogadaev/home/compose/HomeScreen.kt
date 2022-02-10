package org.dogadaev.home.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import org.dogadaev.presentation.viewmodel.HomeViewModel
import org.dogadaev.ui.theme.CbtMateTheme

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    CbtMateTheme {
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
                            removeItem = {
                                viewModel.removeItem(item)
                            }
                        )
                    }
                }
            }
        }
    }
}