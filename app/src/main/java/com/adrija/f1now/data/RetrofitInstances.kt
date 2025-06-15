package com.example.f1app.network

import com.adrija.f1now.data.F1NowService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://ergast.com/"

    val api: F1NowService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(F1NowService::class.java)
    }
}
