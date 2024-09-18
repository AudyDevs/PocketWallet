package com.example.pocketwallet.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pocketwallet.core.type.TypeAmount

@Composable
fun GridTypes(
    type: Int,
    onTypeSelected: (type: Int) -> Unit
) {
    LazyHorizontalGrid(
        modifier = Modifier.height(225.dp),
        rows = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(TypeAmount.entries) { typeAmount ->
            TypeAmountItem(
                typeAmount = typeAmount,
                isSelected = ((type == typeAmount.id)),
                onTypeSelected = { onTypeSelected(it) }
            )
        }
    }
}