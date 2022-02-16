package org.dogadaev.home.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
            LazyColumn(
                modifier = Modifier.
                    fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(
                    horizontal = 16.dp,
                    vertical = 16.dp
                )
            ) {
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
            val (title, setTitle) = remember { mutableStateOf("") }
            val (description, setDescription) = remember { mutableStateOf("") }

            CbtDialog(
                onDismissRequest = { setShowDialog(false) },
                onActionRequest = {
                    viewModel.insertTestItem(
                        title,
                        description
                    )
                },
                titleText = "New diary",
                positiveText = "Create",
                negativeText = "Cancel",
                positiveButtonEnabled = title.isNotEmpty()
            ) {
                TextField(
                    value = title,
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = { newValue ->
                        if (newValue.length <= 25) setTitle(newValue)
                    },
                    label = {
                        Text(text = "Title")
                    },
                    singleLine = true,
                    leadingIcon = {
                        Icon(Icons.Filled.Title, contentDescription = "Diary's title")
                    },
                    trailingIcon = {
                        if (title.isNotEmpty()) IconButton(onClick = { setTitle("") }) {
                            Icon(Icons.Filled.Clear, contentDescription = "Clear title input")
                        }
                    }
                )

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = description,
                    onValueChange = setDescription,
                    label = {
                        Text(text = "Description")
                    },
                    leadingIcon = {
                        Icon(Icons.Filled.Description, contentDescription = "Diary's description")
                    },
                    trailingIcon = {
                        if (description.isNotEmpty()) IconButton(onClick = { setDescription("") }) {
                            Icon(Icons.Filled.Clear, contentDescription = "Clear description input")
                        }
                    }
                )
            }
        }
    }
}