package com.example.pocketwallet.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.pocketwallet.presentation.screen.AmountScreen
import com.example.pocketwallet.presentation.screen.ExpenseScreen
import com.example.pocketwallet.presentation.screen.HomeScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationWrapper(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = NavScreen.Home.route) {
        composable(NavScreen.Home.route) {
            HomeScreen(
                navigateToExpense = {
                    navHostController.navigate(NavScreen.Expense.route) {
                        popUpTo(navHostController.graph.startDestinationId) { inclusive = true }
                        launchSingleTop = true
                    }
                },
                navigateToAmount = { itemSelected ->
                    navHostController.navigate(NavScreen.Amount.route + "/${itemSelected}")
                }
            )
        }
        composable(NavScreen.Expense.route) {
            ExpenseScreen(
                navigateToHome = {
                    navHostController.navigate(NavScreen.Home.route) {
                        navHostController.popBackStack()
                    }
                },
                navigateToAmount = { itemSelected ->
                    navHostController.navigate(NavScreen.Amount.route + "/${itemSelected}")
                }
            )
        }
        composable(
            route = NavScreen.Amount.route + "/{itemSelected}",
            arguments = listOf(
                navArgument("itemSelected") {
                    type = NavType.IntType
                }
            )
        )
        { navBackStackEntry ->
            val itemSelected = navBackStackEntry.arguments?.getInt("itemSelected") ?: 0
            AmountScreen(
                itemSelected = itemSelected,
                navigateToBack = { navHostController.popBackStack() }
            )
        }
    }
}