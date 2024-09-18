package com.example.pocketwallet.presentation.composable

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocketwallet.R
import com.example.pocketwallet.core.type.MenuImages
import com.example.pocketwallet.core.type.TabSelection
import com.example.pocketwallet.presentation.ui.theme.Black

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BasicMenuScreen(
    modifier: Modifier,
    menuImage: MenuImages,
    onSwitchMenu: () -> Unit,
    onTabSelected: (tabSelection: TabSelection?) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Black)
            .padding(top = 8.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        TextTitle(stringResource(id = R.string.app_name), 32.sp)
    }
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 8.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        ImageSwitchMenu(
            modifier = Modifier,
            imageClicked = menuImage,
            onClickImage = {
                onSwitchMenu()
            })
    }
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 70.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        TabFilter(
            modifier = Modifier,
            onTabSelected = {
                onTabSelected(it)
            })
    }
}