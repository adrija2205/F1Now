package com.example.f1now.network

import com.adrija.f1now.data.F1ApiService

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: F1ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.openf1.org/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(F1ApiService::class.java)
    }
}

