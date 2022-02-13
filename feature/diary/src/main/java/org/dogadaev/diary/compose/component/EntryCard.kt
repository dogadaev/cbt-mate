package org.dogadaev.diary.compose.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.dogadaev.entity.Diary
import org.dogadaev.ui.theme.PaddingDefault

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EntryCard(
    entry: Diary.Entry,
    editEntry: () -> Unit,
) {
    Row {
        Card(
            modifier = Modifier
                .padding(PaddingDefault)
                .fillMaxWidth()
                .combinedClickable(
                    onClick = { },
                    onLongClick = editEntry
                )
        ) {
            Row {
                Text(
                    text = entry.situationDescription,
                    modifier = Modifier
                        .padding(PaddingDefault)
                        .weight(1f)
                )
            }
        }
    }
}

@Preview
@Composable
fun CardPreview() {
    EntryCard(
        Diary.Entry(
            "123",
            0,
            "Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title",
            Diary.AutomaticThought(
                "thought",
                "analysis"
            ),
            listOf(),
            "qwerty"
        ),
        { },
    )
}