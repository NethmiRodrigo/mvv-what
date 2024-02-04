package com.example.mvvm.services

import com.example.mvvm.model.ApiResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/")
    suspend fun getNations(@Query("name") name: String) : ApiResponse

    companion object{
        private var apiService: ApiService? = null
        fun getInstance() : ApiService {
            if(apiService == null) {
                apiService = Retrofit.Builder().baseUrl("https://api.nationalize.io")
                    .addConverterFactory(GsonConverterFactory.create()).build()
                    .create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}