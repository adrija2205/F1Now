package com.adrija.f1now.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://ergast.com/api/f1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: F1NowService by lazy {
        retrofit.create(F1NowService::class.java)
    }
}