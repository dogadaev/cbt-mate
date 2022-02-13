package org.dogadaev.home.compose

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PostAdd
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import org.dogadaev.home.R
import org.dogadaev.ui.theme.CbtMateTheme

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