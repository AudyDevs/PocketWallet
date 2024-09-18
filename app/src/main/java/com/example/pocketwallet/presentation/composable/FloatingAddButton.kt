package com.example.pocketwallet.presentation.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pocketwallet.R
import com.example.pocketwallet.presentation.ui.theme.Primary
import com.example.pocketwallet.presentation.ui.theme.White

@Composable
fun FloatingAddButton(
    modifier: Modifier,
    navigateToAmount: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton(
            modifier = Modifier.size(48.dp),
            onClick = {
                navigateToAmount()
            },
            containerColor = Primary
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = stringResource(id = R.string.cd_add),
                tint = White
            )
        }
    }
}