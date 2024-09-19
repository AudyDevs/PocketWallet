package com.example.pocketwallet.presentation.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pocketwallet.domain.model.GroupChart
import com.example.pocketwallet.domain.model.WalletModel

@Composable
fun GroupStats(
    groups: List<GroupChart>,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 125.dp)
            .padding(horizontal = 6.dp)
    ) {

    }
}