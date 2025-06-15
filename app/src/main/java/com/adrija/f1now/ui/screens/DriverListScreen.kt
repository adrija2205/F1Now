// com.adrija.f1app.ui.screens.DriverListScreen.kt
package com.adrija.f1app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.adrija.f1now.ui.components.DriverCard
import com.adrija.f1now.navigation.Routes
import com.example.f1app.viewmodel.DriverViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DriverListScreen(
    navController: NavHostController,
    viewModel: DriverViewModel = viewModel()
) {
    val drivers by viewModel.drivers.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("F1 Drivers") })
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier.fillMaxSize()
        ) {
            items(drivers) { driver ->
                DriverCard(driver = driver) {
                    navController.currentBackStackEntry?.savedStateHandle?.set("driver", driver)
                    navController.navigate(Routes.DRIVER_DETAIL)
                }
            }
        }
    }
}
