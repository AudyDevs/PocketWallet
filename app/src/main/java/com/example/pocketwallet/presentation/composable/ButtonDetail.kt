package com.example.pocketwallet.presentation.composable

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonDetail(
    modifier: Modifier,
    text: String,
    buttonColor: Color,
    textColor: Color,
    onButtonClicked: () -> Unit
) {
    Button(
        onClick = { onButtonClicked() },
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor
        ),
        modifier = modifier
            .height(36.dp)
    ) {
        TextButtonDetail(
            text = text,
            textColor = textColor
        )
    }
}