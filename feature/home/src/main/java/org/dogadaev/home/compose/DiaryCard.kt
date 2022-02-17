package org.dogadaev.home.compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.dogadaev.entity.Diary
import org.dogadaev.ui.extensions.*
import org.dogadaev.ui.theme.PaddingDefault
import org.dogadaev.ui.theme.PaddingSmall
import java.lang.System.currentTimeMillis

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DiaryCard(
    diary: Diary,
    openDiary: () -> Unit,
    removeItem: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .combinedClickable(
                onClick = openDiary,
                onLongClick = removeItem
            ),
        shape = RoundedCornerShape(8.dp),
        elevation = 18.dp
    ) {
        Column(
            modifier = Modifier
                .padding(PaddingDefault)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = diary.title.capitalize(),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )

            if (diary.description.isNotEmpty()) Text(
                modifier = Modifier
                    .padding(
                        top = PaddingSmall
                    )
                    .fillMaxWidth(),
                text = diary.description.capitalize(),
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )

            Text(
                modifier = Modifier
                    .padding(
                        top = PaddingSmall
                    )
                    .fillMaxWidth(),
                text = "Last modified at ${diary.lastModifiedTimestamp.formattedTime} on ${diary.lastModifiedTimestamp.formattedDate}",
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Italic,
                fontSize = 12.sp,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Start
            )
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
            currentTimeMillis(),
            currentTimeMillis(),
            emptyList()
        ),
        { },
        { }
    )
}