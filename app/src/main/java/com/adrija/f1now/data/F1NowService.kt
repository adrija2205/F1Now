package com.adrija.f1now.data

import com.example.example.MRData
import retrofit2.http.GET
interface F1NowService {
    @GET("2023/drivers.json")
    suspend fun getDrivers(): MRData
}