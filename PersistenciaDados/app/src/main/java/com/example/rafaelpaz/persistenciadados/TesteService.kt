package com.example.rafaelpaz.persistenciadados


import retrofit2.Call
import retrofit2.http.GET

interface TesteService {
    @GET("1")
    fun response(): Call<Root>

}