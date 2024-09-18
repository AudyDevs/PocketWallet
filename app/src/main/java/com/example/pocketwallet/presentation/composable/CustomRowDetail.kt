package com.example.pocketwallet.presentation.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomRowDetail(
    modifier: Modifier,
    titleRow: String,
    fieldRow: String
) {
    Row(
        modifier = modifier
            .padding(horizontal = 8.dp)
    ) {
        TextDetail(titleRow, 10.sp, FontWeight.Bold)
        Spacer(modifier = modifier.width(16.dp))
        TextDetail(fieldRow, 10.sp, FontWeight.Normal)
    }
}