package com.adrija.f1now

import F1NowTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adrija.f1now.navigation.AppNavHost
import com.example.f1now.viewmodel.DriverViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            F1NowTheme(darkTheme = true) {
                val viewModel: DriverViewModel = viewModel()
                AppNavHost(viewModel = viewModel)
            }
        }
    }
}

