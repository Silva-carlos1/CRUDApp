package com.example.crudapp.data.network

import retrofit2.http.GET

interface ProductApiService {

    @GET("/")
    suspend fun getHelloWorld(): String
}