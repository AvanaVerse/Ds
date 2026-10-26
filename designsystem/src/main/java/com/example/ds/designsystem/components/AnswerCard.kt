package com.example.ds.designsystem.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DoneAll
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AnswerCard(
    authorName: String,
    authorDetails: String,
    helpfulBadge: String,
    body: String,
    usefulCount: Int,
    usefulCountLabel: (Int) -> String,
    replyLabel: String,
    modifier: Modifier = Modifier,
    onUsefulClick: () -> Unit = {},
    onReplyClick: () -> Unit = {}
) {
    var isUseful by remember { mutableStateOf(false) }
    val displayedUsefulCount = usefulCount + if (isUseful) 1 else 0

    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        color = Color.White,
        border = BorderStroke(1.dp, Color(0xFFD1E4D9))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                UserAvatar(initials = authorName.initials(), size = 32.dp, backgroundColor = Color(0xFFFFEEE8))
                Spacer(modifier = Modifier.width(10.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = authorName,
                        color = Color(0xFF252A38),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = authorDetails,
                        color = Color(0xFF737B8F),
                        fontSize = 11.sp,
                        lineHeight = 17.sp
                    )
                }
                Spacer(modifier = Modifier.width(6.dp))
                Row(
                    modifier = Modifier
                        .background(Color(0xFFEEF7F2), RoundedCornerShape(6.dp))
                        .padding(horizontal = 7.dp, vertical = 5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.DoneAll,
                        contentDescription = null,
                        tint = Color(0xFF36866A),
                        modifier = Modifier.size(14.dp)
                    )
                    Text(
                        text = helpfulBadge,
                        color = Color(0xFF36866A),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium,
                        maxLines = 1
                    )
                }
            }

            Text(
                text = body,
                modifier = Modifier.padding(top = 14.dp),
                color = Color(0xFF252A38),
                fontSize = 14.sp,
                lineHeight = 23.sp
            )

            Row(
                modifier = Modifier.padding(top = 14.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(18.dp)
            ) {
                Row(
                    modifier = Modifier.clickable(
                        role = Role.Button,
                        onClick = {
                            isUseful = !isUseful
                            onUsefulClick()
                        }
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ThumbUp,
                        contentDescription = null,
                        tint = if (isUseful) Color(0xFF36866A) else Color(0xFF737B8F),
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = usefulCountLabel(displayedUsefulCount),
                        color = if (isUseful) Color(0xFF36866A) else Color(0xFF737B8F),
                        fontSize = 11.sp
                    )
                }
                Text(
                    text = replyLabel,
                    modifier = Modifier.clickable(role = Role.Button, onClick = onReplyClick),
                    color = Color(0xFF737B8F),
                    fontSize = 11.sp
                )
            }
        }
    }
}

private fun String.initials(): String =
    split(" ").mapNotNull { it.firstOrNull()?.toString() }.take(2).joinToString("")

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun AnswerCardPreview() {
    MaterialTheme {
        AnswerCard(
            authorName = "Mariana Oliveira",
            authorDetails = "Community member",
            helpfulBadge = "Helpful",
            body = "Example answer text.",
            usefulCount = 8,
            usefulCountLabel = { count -> "$count useful" },
            replyLabel = "Reply",
            modifier = Modifier.padding(12.dp)
        )
    }
}