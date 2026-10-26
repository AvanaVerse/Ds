package com.example.ds.designsystem.components.chips

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip as MaterialFilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ds.designsystem.theme.BorderGray
import com.example.ds.designsystem.theme.DarkNavy
import com.example.ds.designsystem.theme.DesignSystemTheme
import com.example.ds.designsystem.theme.RedOrange

@Composable
fun FilterChip(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    MaterialFilterChip(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = RoundedCornerShape(16.dp),
        label = { Text(text = text, style = MaterialTheme.typography.labelMedium) },
        colors = FilterChipDefaults.filterChipColors(
            containerColor = Color.White,
            labelColor = DarkNavy,
            selectedContainerColor = RedOrange,
            selectedLabelColor = Color.White
        ),
        border = FilterChipDefaults.filterChipBorder(
            enabled = enabled,
            selected = selected,
            borderColor = BorderGray,
            selectedBorderColor = RedOrange
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun FilterChipPreview() {
    DesignSystemTheme {
        FilterChip(text = "Interesses", selected = true, onClick = {})
    }
}