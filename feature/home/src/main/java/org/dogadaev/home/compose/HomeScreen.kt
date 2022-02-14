package org.dogadaev.home.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import org.dogadaev.presentation.viewmodel.HomeViewModel
import org.dogadaev.ui.component.CbtDialog

@Composable
fun HomeScreen(
    openDiary: (diaryId: String) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val (showDialog, setShowDialog) = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            Toolbar(
                createDiary = {
                    setShowDialog(true)
                }
            )
        }
    ) {
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

        if (showDialog) {
            val (inputTitle, setInputTitle) = remember { mutableStateOf("") }

            CbtDialog(
                onDismissRequest = { setShowDialog(false) },
                onActionRequest = { viewModel.insertTestItem(inputTitle) },
                titleText = "New diary",
                positiveText = "Create",
                negativeText = "Cancel"
            ) {
                TextField(
                    value = inputTitle,
                    onValueChange = setInputTitle,
                )
            }
        }
    }
}