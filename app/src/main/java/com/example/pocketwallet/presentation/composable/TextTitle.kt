package com.example.pocketwallet.presentation.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import com.example.pocketwallet.R
import com.example.pocketwallet.presentation.ui.theme.White

@Composable
fun TextTitle(text: String, size: TextUnit) {
    val customFont = FontFamily(Font(R.font.pacifico, FontWeight.Normal))
    Text(
        text = text,
        color = White,
        fontWeight = FontWeight.Bold,
        fontSize = size,
        fontFamily = customFont,
        textAlign = TextAlign.Center
    )
}