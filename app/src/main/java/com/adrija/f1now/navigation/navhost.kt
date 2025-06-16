package com.adrija.f1now.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.adrija.f1now.ui.screens.DriverDetailScreen
import com.adrija.f1now.ui.screens.DriverListScreen
import com.example.f1now.viewmodel.DriverViewModel

@Composable
fun AppNavHost(viewModel: DriverViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.DRIVER_LIST) {
        composable(Routes.DRIVER_LIST) {
            DriverListScreen(viewModel = viewModel, navController = navController)
        }

        composable(
            "${Routes.DRIVER_DETAIL}/{driverNumber}",
            arguments = listOf(navArgument("driverNumber") { type = NavType.StringType })
        ) { backStackEntry ->
            val driverNumber = backStackEntry.arguments?.getString("driverNumber")
            val driver = viewModel.getDriverById(driverNumber)
            if (driver != null) {
                DriverDetailScreen(driver = driver)
            }
        }
    }
}
