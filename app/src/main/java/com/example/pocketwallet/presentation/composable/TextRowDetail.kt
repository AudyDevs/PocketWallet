package com.example.pocketwallet.presentation.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import com.example.pocketwallet.presentation.ui.theme.White

@Composable
fun TextDetail(text: String, size: TextUnit, bold: FontWeight) {
    Text(
        text = text,
        color = White,
        fontWeight = bold,
        fontSize = size,
        textAlign = TextAlign.Start
    )
}