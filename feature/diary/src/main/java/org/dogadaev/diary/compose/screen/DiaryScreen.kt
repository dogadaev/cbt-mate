package org.dogadaev.diary.compose.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PostAdd
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import org.dogadaev.diary.compose.component.EntryCard
import org.dogadaev.diary.compose.component.Toolbar
import org.dogadaev.presentation.viewmodel.DiaryViewModel

@Composable
fun DiaryScreen(
    navigateBack: () -> Unit,
    viewModel: DiaryViewModel = hiltViewModel()
) {
    viewModel.data.collectAsState().value.let { diary ->
        Scaffold(
            topBar = {
                Toolbar(
                    title = diary.title,
                    navigateBack
                )
            }, floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                              viewModel.insertTestEntry()
                    },
                    shape = CutCornerShape(8.dp),
                ) {
                    Icon(
                        Icons.Filled.PostAdd,
                        contentDescription = "Add new entry",
                    )
                }
            }
        ) {
           LazyColumn {
               items(diary.entries) { entry->
                   EntryCard(
                       entry,
                       editEntry = {  }
                   )
               }
           }
        }
    }
}