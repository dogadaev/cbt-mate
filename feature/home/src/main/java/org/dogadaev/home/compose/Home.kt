package org.dogadaev.home.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.dogadaev.presentation.viewmodel.HomeViewModel
import org.dogadaev.ui.theme.CbtMateTheme


@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    CbtMateTheme {
        viewModel.data.collectAsState().value.let { diaries ->
            LazyColumn {
                items(diaries) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .clickable {
                                viewModel.removeTestItem(it)
                            }
                    ) {
                        Card {
                            Text(it.title)
                        }
                    }
                }
            }
        }
    }
}