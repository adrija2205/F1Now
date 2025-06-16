package com.adrija.f1now.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.adrija.f1now.ui.components.DriverCard
import com.adrija.f1now.navigation.Routes
import com.example.f1now.viewmodel.DriverViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DriverListScreen(
    navController: NavHostController,
    viewModel: DriverViewModel = viewModel()
) {
    val drivers by viewModel.drivers.collectAsState()
    var searchQuery by remember { mutableStateOf("") }

    val filteredDrivers = drivers.filter {
        val name = it.full_name?.lowercase().orEmpty()
        name.contains(searchQuery.lowercase())
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "F1Now - Drivers",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Search Drivers") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon"
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            LazyColumn(
                contentPadding = PaddingValues(vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            )  {
                items(filteredDrivers) { driver ->
                    DriverCard(driver = driver) {
                        navController.navigate("${Routes.DRIVER_DETAIL}/${driver.driver_number}")
                    }
                }
            }
        }
    }
}