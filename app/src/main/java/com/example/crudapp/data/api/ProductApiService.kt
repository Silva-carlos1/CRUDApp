package com.example.crudapp.data.api

import com.example.crudapp.data.model.ProductsResponse
import com.example.crudapp.data.model.teste
import com.example.crudapp.model.Product
import retrofit2.http.GET

interface ProductApiService {

    @GET("/products")
    suspend fun getAllProducts(): ProductsResponse
}