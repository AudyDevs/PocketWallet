package com.example.pocketwallet.presentation.navigation

sealed class NavScreen(val route: String) {
    data object Home : NavScreen("home")
    data object Expense : NavScreen("expense")
    data object Income : NavScreen("Income")
    data object AddAmount : NavScreen("AddAmount")
    data object Filter : NavScreen("Filter")
}