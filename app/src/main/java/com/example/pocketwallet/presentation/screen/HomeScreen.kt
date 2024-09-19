package com.example.pocketwallet.presentation.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pocketwallet.core.Dates
import com.example.pocketwallet.core.type.MenuImages
import com.example.pocketwallet.presentation.composable.BasicMenuScreen
import com.example.pocketwallet.presentation.composable.FloatingAddButton
import com.example.pocketwallet.presentation.composable.GroupedLazyColumn
import com.example.pocketwallet.presentation.viewmodel.HomeViewModel
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
    navigateToExpense: () -> Unit,
    navigateToAmount: (itemSelected: Int) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    viewModel.getWallets()
    val wallets by viewModel.wallet.collectAsState()
    val groupsList by viewModel.groupsList.collectAsState()
    var itemSelected by remember { mutableIntStateOf(0) }
    var initialDateFilter by remember { mutableStateOf<Date?>(null) }
    var finalDateFilter by remember { mutableStateOf<Date?>(null) }

    if (wallets.isNotEmpty()) {
        viewModel.getGroupsList(initialDateFilter, finalDateFilter)
    }

    BasicMenuScreen(modifier = Modifier,
        menuImage = MenuImages.ChartMenu,
        onSwitchMenu = { navigateToExpense() },
        onTabSelected = { tabSelection ->
            if (tabSelection != null) {
                val (calculationInitialDate, calculationFinalDate) =
                    Dates().calculationDateFilter(tabSelection)
                initialDateFilter = calculationInitialDate
                finalDateFilter = calculationFinalDate
            }
        }
    )
    GroupedLazyColumn(
        group = groupsList,
        modifier = Modifier,
        onItemSelected = {
            itemSelected = it
            navigateToAmount(itemSelected)
        }
    )
    FloatingAddButton(
        modifier = Modifier,
        navigateToAmount = { navigateToAmount(0) }
    )
}