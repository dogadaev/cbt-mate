package org.dogadaev.home.compose

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
fun DiaryCard(
    diary: Diary,
    openDiary: () -> Unit,
    removeItem: () -> Unit,
) {
    Row {
        Card(
            modifier = Modifier
                .padding(PaddingDefault)
                .fillMaxWidth()
                .combinedClickable(
                    onClick = openDiary,
                    onLongClick = removeItem
                )
        ) {
            Row {
                Text(
                    text = diary.title,
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
    DiaryCard(
        Diary(
            "123",
            "Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title Title",
            "Description",
            0,
            emptyList()
        ),
        { },
        { }
    )
}