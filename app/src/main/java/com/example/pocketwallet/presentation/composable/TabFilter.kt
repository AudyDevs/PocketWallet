package com.example.pocketwallet.presentation.composable

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pocketwallet.core.Dates
import com.example.pocketwallet.core.type.TabSelection
import com.example.pocketwallet.core.type.TabSelection.Companion.getTabSelectionById
import com.example.pocketwallet.presentation.ui.theme.Black
import com.example.pocketwallet.presentation.ui.theme.Primary
import com.example.pocketwallet.presentation.ui.theme.White

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TabFilter(
    modifier: Modifier,
    onTabSelected: (tabSelection: TabSelection?) -> Unit
) {
    var selectedTabId by remember { mutableIntStateOf(0) }
    val tabs = TabSelection.entries
    ScrollableTabRow(
        selectedTabIndex = selectedTabId,
        modifier = modifier.fillMaxWidth(),
        edgePadding = 0.dp,
        containerColor = Black,
        contentColor = White,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier.tabIndicatorOffset(tabPositions[selectedTabId]),
                color = Primary
            )
        }
    ) {
        tabs.forEachIndexed { index, tab ->
            val title = if (tab.minusMonth > 0) {
                val (month, year) = Dates().minusMonth(tab.minusMonth)
                stringResource(id = tab.titleTab, month, year)
            } else {
                stringResource(id = tab.titleTab)
            }
            Tab(
                selected = selectedTabId == index,
                onClick = {
                    selectedTabId = index
                    onTabSelected(getTabSelectionById(selectedTabId))
                },
                text = {
                    Text(
                        text = title,
                        color = if (selectedTabId == index) Primary else White
                    )
                }
            )
        }
    }
}