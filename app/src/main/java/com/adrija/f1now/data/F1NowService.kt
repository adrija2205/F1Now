package com.adrija.f1now.data

import com.adrija.f1now.model.Drivers
import retrofit2.http.GET

interface F1ApiService {
    @GET("drivers")
    suspend fun getDrivers(): List<Drivers>
}



