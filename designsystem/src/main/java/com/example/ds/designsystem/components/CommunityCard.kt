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
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CommunityCard(
    authorName: String,
    metadata: String,
    title: String,
    summary: String,
    tags: List<String>,
    actionLabel: String,
    modifier: Modifier = Modifier,
    onOpenConversation: () -> Unit = {}
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        color = Color.White,
        border = BorderStroke(1.dp, Color(0xFFE1E5ED)),
        shadowElevation = 1.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                UserAvatar(
                    initials = authorName.split(" ").mapNotNull { it.firstOrNull()?.toString() }.take(2).joinToString(""),
                    size = 32.dp,
                    backgroundColor = Color(0xFFFFE9E3)
                )
                Spacer(modifier = Modifier.width(10.dp))
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

            Text(
                text = title,
                modifier = Modifier.padding(top = 12.dp),
                color = Color(0xFF252A38),
                fontSize = 16.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = summary,
                modifier = Modifier.padding(top = 6.dp),
                color = Color(0xFF697286),
                fontSize = 13.sp,
                lineHeight = 20.sp
            )

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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .clickable(role = Role.Button, onClick = onOpenConversation),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = actionLabel,
                    color = Color(0xFFDF3211),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Outlined.ChevronRight,
                    contentDescription = null,
                    tint = Color(0xFFDF3211),
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun CommunityCardPreview() {
    MaterialTheme {
        CommunityCard(
            authorName = "CodeHub Community",
            metadata = "12 members",
            title = "Android developers",
            summary = "A place to discuss Android development.",
            tags = listOf("Android", "Compose"),
            actionLabel = "Open community",
            modifier = Modifier.padding(12.dp)
        )
    }
}