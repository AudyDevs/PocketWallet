package com.example.pocketwallet.presentation.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.pocketwallet.R
import com.example.pocketwallet.presentation.ui.theme.White

@Composable
fun CustomEditText(
    value: String,
    textLabel: Int,
    keyboardOptions: KeyboardOptions,
    showTrailingIcon: Boolean,
    onValueChange: (value: String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = { newValue -> onValueChange(newValue) },
        label = {
            TextDetail(
                stringResource(id = textLabel),
                12.sp,
                FontWeight.Normal
            )
        },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = keyboardOptions,
        singleLine = true,
        trailingIcon = {
            if (showTrailingIcon) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_euro),
                    contentDescription = null,
                    tint = Color.Gray
                )
            }
        },
        textStyle = TextStyle(color = White)
    )
}