package com.example.pocketwallet.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pocketwallet.presentation.screen.AddAmountScreen
import com.example.pocketwallet.presentation.screen.ExpenseScreen
import com.example.pocketwallet.presentation.screen.FilterScreen
import com.example.pocketwallet.presentation.screen.HomeScreen
import com.example.pocketwallet.presentation.screen.IncomeScreen

@Composable
fun NavigationWrapper(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = NavScreen.Home.route) {
        composable(NavScreen.Home.route) {
            HomeScreen()
        }
        composable(NavScreen.Expense.route) {
            ExpenseScreen()
        }
        composable(NavScreen.Income.route) {
            IncomeScreen()
        }
        composable(NavScreen.AddAmount.route) {
            AddAmountScreen()
        }
        composable(NavScreen.Filter.route) {
            FilterScreen()
        }
    }
}