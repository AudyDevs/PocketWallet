package com.example.pocketwallet.presentation.navigation

sealed class NavScreen(val route: String) {
    data object Home : NavScreen("home")
    data object Expense : NavScreen("expense")
    data object Amount : NavScreen("Amount")
    data object Detail : NavScreen("Detail")
}