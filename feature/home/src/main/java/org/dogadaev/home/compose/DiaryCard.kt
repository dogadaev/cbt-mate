package org.dogadaev.home.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.dogadaev.entity.Diary
import org.dogadaev.ui.theme.PaddingDefault

@Composable
fun DiaryCard(
    diary: Diary,
    onCardClick: () -> Unit
) {
    Row{
        Card(
            modifier = Modifier
                .padding(PaddingDefault)
                .fillMaxWidth()
                .clickable(onClick = onCardClick)
        ) {
            Text(
                text = diary.title,
                modifier = Modifier
                    .padding(PaddingDefault)
            )
        }
    }
}