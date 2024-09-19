package com.example.pocketwallet.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.pocketwallet.core.type.TypeAmount
import com.example.pocketwallet.domain.model.GroupChart

@Composable
fun TypeAmountLazyColumn(
    groupsSorted: List<GroupChart>,
    totalGroupAmount: Float
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        items(groupsSorted) { item ->
            if (item.type > 0) {
                val groupProportion =
                    String.format("%.2f", (item.totalAmount / totalGroupAmount) * 100)
                val typeAmount = TypeAmount.getTypeAmountById(item.type)!!
                ItemTypeAmount(typeAmount, groupProportion, item.totalAmount)
            }
        }
    }
}