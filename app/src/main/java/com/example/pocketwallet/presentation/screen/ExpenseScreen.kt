package com.example.pocketwallet.presentation.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pocketwallet.core.Dates
import com.example.pocketwallet.core.type.MenuImages
import com.example.pocketwallet.presentation.composable.BasicMenuScreen
import com.example.pocketwallet.presentation.composable.GroupStats
import com.example.pocketwallet.presentation.composable.IconEmptyChart
import com.example.pocketwallet.presentation.viewmodel.HomeViewModel
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ExpenseScreen(
    navigateToHome: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    viewModel.getWallets()
    val wallets by viewModel.wallet.collectAsState()
    val groupsChart by viewModel.groupsChart.collectAsState()
    var initialDateFilter by remember { mutableStateOf<Date?>(null) }
    var finalDateFilter by remember { mutableStateOf<Date?>(null) }

    if (wallets.isNotEmpty()) {
        viewModel.getGroupsChart(initialDateFilter, finalDateFilter)
    }

    BasicMenuScreen(modifier = Modifier,
        menuImage = MenuImages.ListMenu,
        onSwitchMenu = { navigateToHome() },
        onTabSelected = { tabSelection ->
            if (tabSelection != null) {
                val (calculationInitialDate, calculationFinalDate) =
                    Dates().calculationDateFilter(tabSelection)
                initialDateFilter = calculationInitialDate
                finalDateFilter = calculationFinalDate
            }
        }
    )
    if (groupsChart.isEmpty()) {
        IconEmptyChart()
    } else {
        GroupStats(
            groups = groupsChart,
            modifier = Modifier
        )
    }
}