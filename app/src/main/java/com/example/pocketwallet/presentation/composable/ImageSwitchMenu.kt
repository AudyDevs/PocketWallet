package com.example.pocketwallet.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pocketwallet.R
import com.example.pocketwallet.core.type.MenuImages
import com.example.pocketwallet.presentation.ui.theme.White

@Composable
fun ImageSwitchMenu(
    modifier: Modifier,
    imageClicked: MenuImages,
    onClickImage: () -> Unit
) {
    val painter = when (imageClicked) {
        MenuImages.ChartMenu -> {
            painterResource(id = R.drawable.ic_view_chart)
        }

        MenuImages.ListMenu -> {
            painterResource(id = R.drawable.ic_view_list)
        }
    }
    Image(
        painter = painter,
        contentDescription = null,
        colorFilter = ColorFilter.tint(White),
        modifier = modifier
            .padding(top = 16.dp)
            .padding(end = 24.dp)
            .size(32.dp)
            .clickable {
                onClickImage()
            })
}