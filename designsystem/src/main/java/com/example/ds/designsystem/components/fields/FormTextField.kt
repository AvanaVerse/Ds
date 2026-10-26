package com.example.ds.designsystem.components.fields

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ds.designsystem.theme.BorderGray
import com.example.ds.designsystem.theme.DarkNavy
import com.example.ds.designsystem.theme.DesignSystemTheme

@Composable
fun FormTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(text = label, color = DarkNavy, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth().height(56.dp),
            enabled = enabled,
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            textStyle = MaterialTheme.typography.bodyLarge,
            placeholder = { Text(text = placeholder, style = MaterialTheme.typography.bodyLarge) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = BorderGray,
                unfocusedBorderColor = BorderGray,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedTextColor = DarkNavy,
                unfocusedTextColor = DarkNavy,
                focusedPlaceholderColor = DarkNavy.copy(alpha = 0.6f),
                unfocusedPlaceholderColor = DarkNavy.copy(alpha = 0.6f)
            )
        )
    }
}

@Preview(showBackground = true, widthDp = 404)
@Composable
private fun FormTextFieldPreview() {
    DesignSystemTheme {
        FormTextField(value = "", onValueChange = {}, label = "Titulo", placeholder = "Digite o titulo")
    }
}