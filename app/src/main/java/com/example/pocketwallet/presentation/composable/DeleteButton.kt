package com.example.pocketwallet.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pocketwallet.R
import com.example.pocketwallet.presentation.ui.theme.White

@Composable
fun DeleteButton(
    onButtonClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_delete),
            colorFilter = ColorFilter.tint(White),
            contentDescription = stringResource(id = R.string.cd_delete),
            modifier = Modifier
                .clickable {
                    onButtonClick()
                }
        )
    }
}