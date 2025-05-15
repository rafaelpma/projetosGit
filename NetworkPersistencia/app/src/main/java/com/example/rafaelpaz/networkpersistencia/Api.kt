package com.example.rafaelpaz.networkpersistencia

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {
val httpClient = OkHttpClient.Builder()

    val gson = GsonBuilder().setLenient().create()
    val retrofit: Retrofit =
        Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .baseUrl("https://swapi.co/api/people/")
                .build()


    fun testService(): TesteService{
        return retrofit.create(TesteService::class.java)
    }
}