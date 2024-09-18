package com.example.pocketwallet.presentation.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocketwallet.presentation.ui.theme.White

@Composable
fun RowDatePicker(
    formatDate: String,
    onPreviewDay: () -> Unit,
    onDatePickerSelected: () -> Unit,
    onNextDay: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box(
            modifier = Modifier
                .border(1.dp, Color.Gray, ShapeDefaults.ExtraSmall)
                .height(52.dp)
                .weight(0.22f)
                .clickable { onPreviewDay() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = null,
                tint = White
            )
        }
        Box(
            modifier = Modifier
                .border(1.dp, Color.Gray, ShapeDefaults.ExtraSmall)
                .height(52.dp)
                .weight(1f)
                .clickable { onDatePickerSelected() },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = formatDate,
                fontSize = 12.sp,
                color = White
            )
        }
        Box(
            modifier = Modifier
                .border(1.dp, Color.Gray, ShapeDefaults.ExtraSmall)
                .height(52.dp)
                .weight(0.25f)
                .clickable { onNextDay() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null,
                tint = White
            )
        }
    }
}