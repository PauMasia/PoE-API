package com.example.poe_api_paumasia

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface API_Interface {
    @GET("/items")
    suspend fun getData(): List<ObjetoPoE>

    companion object{
        const val BASE_URL= "https://paumasia.pythonanywhere.com/"
    }
}