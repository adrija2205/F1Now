package com.adrija.f1now.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.f1app.viewmodel.DriverViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DriverDetailScreen(driverId: String?, viewModel: DriverViewModel = viewModel()) {
    val driver = remember { driverId?.let { viewModel.getDriverById(it) } }

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text("Driver Details") },
                colors = TopAppBarDefaults.smallTopAppBarColors()
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            // content
        }
    }
}
