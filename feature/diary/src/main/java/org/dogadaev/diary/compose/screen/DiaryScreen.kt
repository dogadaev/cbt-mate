package org.dogadaev.diary.compose.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import org.dogadaev.presentation.viewmodel.DiaryViewModel
import org.dogadaev.ui.theme.PaddingDefault

@Composable
fun DiaryScreen(
    viewModel: DiaryViewModel = hiltViewModel()
) {
    viewModel.data.collectAsState().value.let { diary ->
        Column {
            Text(
                text = diary.title,
                modifier = Modifier
                    .padding(PaddingDefault)
                    .weight(1f)
            )
        }
    }
}