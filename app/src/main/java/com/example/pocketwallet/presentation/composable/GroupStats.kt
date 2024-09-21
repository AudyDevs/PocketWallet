package com.example.pocketwallet.presentation.composable

import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.pocketwallet.core.type.TypeAmount.Companion.getTypeAmountById
import com.example.pocketwallet.domain.model.GroupChart
import com.example.pocketwallet.presentation.ui.theme.Black
import com.example.pocketwallet.presentation.ui.theme.White

@Composable
fun GroupStats(
    groups: List<GroupChart>,
    modifier: Modifier
) {
    if (groups.isNotEmpty()) {
        val groupsSorted = groups.sortedByDescending { it.totalAmount }
        val colors: MutableList<Color> = mutableListOf()
        val proportions: MutableList<Float> = mutableListOf()
        var totalGroupAmount = 0f
        groupsSorted.forEach { groupChart ->
            val typeAmount = getTypeAmountById(groupChart.type)
            colors.add(typeAmount?.color ?: Black)
            totalGroupAmount += groupChart.totalAmount
        }
        groupsSorted.forEach { groupChart ->
            val groupProportion = groupChart.totalAmount / totalGroupAmount
            proportions.add(groupProportion)
        }
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(top = 125.dp)
                .padding(horizontal = 6.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(24.dp))
                Box(
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    AnimatedCircle(
                        modifier = Modifier
                            .height(200.dp)
                            .fillMaxWidth(),
                        dividerLengthInDegrees = 2.5f,
                        strokeChart = 32.dp,
                        proportions = proportions,
                        colors = colors
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "${String.format("%.2f", totalGroupAmount)} €",
                        fontWeight = FontWeight.Bold,
                        color = White
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                TypeAmountLazyColumn(groupsSorted, totalGroupAmount)
            }
        }
    }
}