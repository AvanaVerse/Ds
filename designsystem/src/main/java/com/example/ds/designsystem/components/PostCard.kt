package com.example.ds.designsystem.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PostCard(
    authorName: String,
    metadata: String,
    title: String,
    bodyParagraphs: List<String>,
    modifier: Modifier = Modifier,
    tags: List<String> = emptyList(),
    likesLabel: String? = null,
    responsesLabel: String? = null
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        color = Color.White,
        border = BorderStroke(1.dp, Color(0xFFE1E5ED)),
        shadowElevation = 1.dp
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                UserAvatar(
                    initials = authorName.split(" ").mapNotNull { it.firstOrNull()?.toString() }.take(2).joinToString(""),
                    size = 34.dp
                )
                Spacer(modifier = Modifier.width(9.dp))
                Column {
                    Text(
                        text = authorName,
                        color = Color(0xFF252A38),
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(text = metadata, color = Color(0xFF737B8F), fontSize = 11.sp)
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 14.dp, bottom = 12.dp)
                    .height(1.dp)
                    .background(Color(0xFFE1E5ED))
            )

            Text(
                text = title,
                color = Color(0xFF252A38),
                fontSize = 16.sp,
                lineHeight = 23.sp,
                fontWeight = FontWeight.Bold
            )
            bodyParagraphs.forEachIndexed { index, paragraph ->
                Text(
                    text = paragraph,
                    modifier = Modifier.padding(top = if (index == 0) 10.dp else 16.dp),
                    color = Color(0xFF252A38),
                    fontSize = 13.sp,
                    lineHeight = 20.sp
                )
            }

            if (tags.isNotEmpty()) {
                Row(
                    modifier = Modifier.padding(top = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    tags.forEach { tag ->
                        Text(
                            text = tag,
                            modifier = Modifier
                                .background(Color(0xFFF5F6FA), RoundedCornerShape(50))
                                .padding(horizontal = 9.dp, vertical = 5.dp),
                            color = Color(0xFF697286),
                            fontSize = 10.sp
                        )
                    }
                }
            }

            if (likesLabel != null || responsesLabel != null) {
                Row(
                    modifier = Modifier.padding(top = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    if (likesLabel != null) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Outlined.FavoriteBorder,
                                contentDescription = null,
                                tint = Color(0xFF737B8F),
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(text = likesLabel, color = Color(0xFF737B8F), fontSize = 11.sp)
                        }
                    }
                    if (responsesLabel != null) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Outlined.ChatBubbleOutline,
                                contentDescription = null,
                                tint = Color(0xFF737B8F),
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(text = responsesLabel, color = Color(0xFF737B8F), fontSize = 11.sp)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 390)
@Composable
private fun PostCardPreview() {
    MaterialTheme {
        PostCard(
            authorName = "Luiza Costa",
            metadata = "Published recently",
            title = "Example publication",
            bodyParagraphs = listOf("Add the publication text here."),
            tags = listOf("Compose", "Android"),
            likesLabel = "12 likes",
            responsesLabel = "3 replies",
            modifier = Modifier.padding(12.dp)
        )
    }
}