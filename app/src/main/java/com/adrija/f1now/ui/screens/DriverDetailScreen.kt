package com.adrija.f1now.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adrija.f1now.model.Drivers


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DriverDetailScreen(driver: Drivers) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(driver.full_name ?: "Driver Details") })
        }
    ) { padding ->
        Column(modifier = Modifier
            .padding(padding)
            .padding(16.dp)) {
            Text("Number: ${driver.driver_number ?: "N/A"}")
            Text("Name Acronym: ${driver.name_acronym ?: "N/A"}")
            Text("Team: ${driver.team_name ?: "N/A"}")
        }
    }
}
