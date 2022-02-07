package org.dogadaev.home.compose

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PostAdd
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import org.dogadaev.home.R

@Composable
fun Toolbar(
    createDiary: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name)
            )
        },
        actions = {
            IconButton(onClick = createDiary) {
                Icon(Icons.Filled.PostAdd, contentDescription = "Localized description")
            }
        }
    )
}