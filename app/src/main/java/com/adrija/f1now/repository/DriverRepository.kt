package com.adrija.f1now.repository

import com.adrija.f1now.model.Drivers
import com.example.f1now.network.RetrofitInstance

class DriverRepository {
    suspend fun getDrivers(): List<Drivers> {
        return RetrofitInstance.api.getDrivers()
    }
}
