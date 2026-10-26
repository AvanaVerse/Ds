package com.example.ds.designsystem.components.navigation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ds.designsystem.theme.BorderGray
import com.example.ds.designsystem.theme.DarkNavy
import com.example.ds.designsystem.theme.DesignSystemTheme
import com.example.ds.designsystem.theme.RedOrange

@Composable
fun Pagination(
    currentPage: Int,
    totalPages: Int,
    onPreviousPage: () -> Unit,
    onNextPage: () -> Unit,
    modifier: Modifier = Modifier,
    previousPageDescription: String = "Previous page",
    nextPageDescription: String = "Next page",
    pageLabel: (Int, Int) -> String = { current, total -> "Page $current of $total" }
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedIconButton(
            onClick = onPreviousPage,
            enabled = currentPage > 1,
            modifier = Modifier.size(36.dp),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, BorderGray),
            colors = IconButtonDefaults.outlinedIconButtonColors(
                containerColor = Color.White,
                contentColor = DarkNavy,
                disabledContainerColor = Color.White,
                disabledContentColor = DarkNavy.copy(alpha = 0.38f)
            )
        ) {
            Icon(imageVector = Icons.Default.ChevronLeft, contentDescription = previousPageDescription)
        }

        Surface(color = RedOrange, shape = RoundedCornerShape(16.dp)) {
            Box(
                modifier = Modifier.height(36.dp).padding(horizontal = 12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = pageLabel(currentPage, totalPages),
                    color = Color.White,
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }

        OutlinedIconButton(
            onClick = onNextPage,
            enabled = currentPage < totalPages,
            modifier = Modifier.size(36.dp),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, BorderGray),
            colors = IconButtonDefaults.outlinedIconButtonColors(
                containerColor = Color.White,
                contentColor = DarkNavy,
                disabledContainerColor = Color.White,
                disabledContentColor = DarkNavy.copy(alpha = 0.38f)
            )
        ) {
            Icon(imageVector = Icons.Default.ChevronRight, contentDescription = nextPageDescription)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PaginationPreview() {
    DesignSystemTheme {
        Pagination(currentPage = 1, totalPages = 5, onPreviousPage = {}, onNextPage = {}, modifier = Modifier.padding(16.dp))
    }
}