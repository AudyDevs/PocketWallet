package com.example.pocketwallet.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.pocketwallet.presentation.ui.theme.Black
import com.example.pocketwallet.presentation.ui.theme.White

@Composable
fun ItemTypeAmount(
    typeAmount: TypeAmount,
    groupProportion: String,
    totalAmount: Float
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(typeAmount.color),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = typeAmount.image),
                contentDescription = stringResource(id = typeAmount.title),
                modifier = Modifier
                    .size(24.dp)
            )
        }
        Text(
            text = stringResource(id = typeAmount.title),
            color = White,
            fontSize = 14.sp,
            modifier = Modifier
                .background(Black)
                .padding(start = 16.dp)
                .padding(end = 16.dp)
        )
        Text(
            text = "$groupProportion %",
            color = White,
            fontSize = 14.sp,
            modifier = Modifier
                .background(Black)
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "$totalAmount €",
            color = White,
            fontSize = 14.sp,
            modifier = Modifier
                .background(Black)
        )
    }
}