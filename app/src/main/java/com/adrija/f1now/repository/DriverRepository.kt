package com.adrija.f1now.repository

import com.example.f1app.network.RetrofitInstance

class DriverRepository {
    suspend fun getDrivers() = RetrofitInstance.api.getDrivers()
}
