package org.dogadaev.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Title
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import org.dogadaev.ui.theme.CbtMateTheme

@Composable
fun CbtDialog(
    onDismissRequest: () -> Unit,
    onActionRequest: () -> Unit,
    properties: DialogProperties = DialogProperties(),
    titleText: String,
    positiveText: String,
    negativeText: String,
    positiveButtonEnabled: Boolean,
    content: @Composable () -> Unit
) {
    CustomDialog(
        onDismissRequest = onDismissRequest,
        properties = properties,
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    16.dp
                ),
            textAlign = TextAlign.Center,
            text = titleText
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) { content() }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            TextButton(
                onClick = onDismissRequest
            ) {
                Text(
                    text = negativeText.uppercase()
                )
            }
            TextButton(
                onClick = {
                    onActionRequest()
                    onDismissRequest()
                },
                enabled = positiveButtonEnabled
            ) {
                Text(
                    text = positiveText.uppercase()
                )
            }
        }
    }
}

@Composable
fun CustomDialog(
    onDismissRequest: () -> Unit,
    properties: DialogProperties = DialogProperties(),
    content: @Composable ColumnScope.() -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = properties,
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            shape = RoundedCornerShape(16.dp),
            elevation = 8.dp,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                content = content
            )
        }
    }
}

@Preview
@Composable
fun DialogPreview() {
    CustomDialog(onDismissRequest = { }) {
        Text(text = "Test")
    }
}