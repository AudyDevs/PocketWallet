package com.example.pocketwallet.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocketwallet.core.type.TypeAmount
import com.example.pocketwallet.presentation.ui.theme.Primary
import com.example.pocketwallet.presentation.ui.theme.SemiTransparentWhite20
import com.example.pocketwallet.presentation.ui.theme.White

@Composable
fun TypeAmountItem(
    typeAmount: TypeAmount,
    isSelected: Boolean,
    onTypeSelected: (type: Int) -> Unit
) {
    val backcolorShape = if (isSelected) Primary else SemiTransparentWhite20
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(backcolorShape)
                .padding(10.dp)
                .clickable {
                    onTypeSelected(typeAmount.id)
                }
        ) {
            Image(
                painter = painterResource(id = typeAmount.image),
                contentDescription = stringResource(id = typeAmount.title),
                Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = stringResource(id = typeAmount.title),
            color = White,
            fontSize = 11.sp
        )
    }
}
