package com.example.pocketwallet.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocketwallet.R
import com.example.pocketwallet.presentation.ui.theme.White

@Composable
fun IconEmptyChart() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 125.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedCircle(
            modifier = Modifier
                .height(125.dp)
                .fillMaxWidth(),
            dividerLengthInDegrees = 3f,
            strokeChart = 22.dp,
            proportions = listOf(0.30f, 0.20f, 0.15f, 0.35f),
            colors = listOf(White, White, White, White)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = R.string.empty_chart),
            color = White,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
    }
}