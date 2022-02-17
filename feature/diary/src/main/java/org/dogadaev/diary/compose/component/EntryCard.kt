package org.dogadaev.diary.compose.component

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PostAdd
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.dogadaev.entity.Diary
import org.dogadaev.ui.extensions.formattedDate
import org.dogadaev.ui.extensions.formattedTime
import org.dogadaev.ui.theme.*
import kotlin.math.roundToInt

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EntryCard(
    entry: Diary.Entry,
    editEntry: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        val icon = Icons.Outlined.Circle

        Canvas(
            Modifier
                .width(32.dp)
                .padding(
                    end = 24.dp,
                    bottom = 4.dp,
                    top = 28.dp,
                )
                .fillMaxHeight()
                .clip(RectangleShape)
        ) {
            val step = 4.dp
            val angleDegrees = 45f
            val stepPx = step.toPx()
            val stepsCount = (size.height / stepPx).roundToInt()
            val stride = size.height / stepsCount
            val length = Size(width = 1.dp.value, height = size.width * 2)

            for (i in 0 until stepsCount - 2) {
                val rect = Rect(
                    offset = Offset(y = i * stride, x = 0f),
                    size = length,
                )
                rotate(angleDegrees, pivot = rect.center) {
                    drawRect(
                        Grey300,
                        topLeft = rect.topLeft,
                        size = rect.size,
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .combinedClickable(
                    onClick = { },
                    onLongClick = editEntry
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            bottom = PaddingSmall
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .padding(end = PaddingDefault),
                        text = "${entry.timestamp.formattedDate} at ${entry.timestamp.formattedTime}",
                        fontWeight = FontWeight.Light,
                        fontStyle = FontStyle.Italic,
                        fontSize = 12.sp,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Start
                    )

                    Divider(
                        modifier = Modifier
                            .weight(1f)
                    )
                }

                Text(
                    text = entry.situationDescription,
                    modifier = Modifier
                        .padding(
                            end = PaddingDefault
                        )
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
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