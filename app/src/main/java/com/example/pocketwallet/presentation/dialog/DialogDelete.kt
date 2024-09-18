package com.example.pocketwallet.presentation.dialog

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pocketwallet.R
import com.example.pocketwallet.presentation.composable.ButtonDetail
import com.example.pocketwallet.presentation.ui.theme.Black
import com.example.pocketwallet.presentation.ui.theme.SemiTransparentWhite85
import com.example.pocketwallet.presentation.ui.theme.White

@Composable
fun DialogDelete(
    showDialog: Boolean,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = { Text(stringResource(id = R.string.title_delete)) },
            text = { Text(stringResource(id = R.string.content_delete)) },
            confirmButton = {
                ButtonDetail(
                    modifier = Modifier,
                    text = stringResource(id = R.string.detail_button_text_delete),
                    buttonColor = SemiTransparentWhite85,
                    textColor = Color.Red,
                    onButtonClicked = { onConfirm() })
            },
            dismissButton = {
                ButtonDetail(
                    modifier = Modifier,
                    text = stringResource(id = R.string.detail_button_text_cancel),
                    buttonColor = SemiTransparentWhite85,
                    textColor = Black,
                    onButtonClicked = { onDismiss() })
            },
            titleContentColor = White,
            textContentColor = White,
            containerColor = Black,
            shape = MaterialTheme.shapes.medium,
            tonalElevation = 8.dp
        )
    }
}