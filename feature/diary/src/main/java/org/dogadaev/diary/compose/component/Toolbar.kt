package org.dogadaev.diary.compose.component

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun Toolbar(
    title: String,
    navigateBack: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(onClick = navigateBack) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Navigate back")
            }
        }
    )
}