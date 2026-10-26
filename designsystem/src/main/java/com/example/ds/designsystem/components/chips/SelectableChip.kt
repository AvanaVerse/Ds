package com.example.ds.designsystem.components.chips

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
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
fun SelectableChip(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    FilterChip(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        label = { Text(text = text, style = MaterialTheme.typography.labelMedium) },
        shape = RoundedCornerShape(16.dp),
        leadingIcon = if (selected) {
            { Icon(imageVector = Icons.Default.Check, contentDescription = null) }
        } else {
            null
        },
        colors = FilterChipDefaults.filterChipColors(
            containerColor = Color.White,
            labelColor = DarkNavy,
            selectedContainerColor = Color.White,
            selectedLabelColor = RedOrange,
            selectedLeadingIconColor = RedOrange
        ),
        border = FilterChipDefaults.filterChipBorder(
            enabled = enabled,
            selected = selected,
            borderColor = BorderGray,
            selectedBorderColor = RedOrange,
            borderWidth = 1.dp,
            selectedBorderWidth = 1.dp
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun SelectableChipPreview() {
    DesignSystemTheme {
        SelectableChip(text = "Kotlin", selected = true, onClick = {})
    }
}