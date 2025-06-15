package com.adrija.f1now.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.adrija.f1app.ui.screens.DriverListScreen
import com.adrija.f1now.ui.screens.DriverDetailScreen
import com.example.f1app.viewmodel.DriverViewModel

@Composable
fun AppNavHost(viewModel: DriverViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.DRIVER_LIST) {
        composable(Routes.DRIVER_LIST) {
            DriverListScreen(viewModel = viewModel, navController = navController)
        }

        composable(
            "${Routes.DRIVER_DETAIL}/{driverId}",
            arguments = listOf(navArgument("driverId") { type = NavType.StringType })
        ) { backStackEntry ->
            val driverId = backStackEntry.arguments?.getString("driverId")
            val driver = viewModel.getDriverById(driverId)
            if (driver != null) {
                DriverDetailScreen(driver = driver)
            }
        }
    }
}
