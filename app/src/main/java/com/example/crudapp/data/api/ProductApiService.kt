package com.example.crudapp.data.api

import com.example.crudapp.data.model.CreateProductDto
import com.example.crudapp.data.model.ProductResponse
import com.example.crudapp.data.model.ProductsResponse
import com.example.crudapp.data.model.UpdateProductDto
import com.example.crudapp.model.Product
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface ProductApiService {

    @POST("products")
    suspend fun createProduct(@Body productCreateDTO: CreateProductDto): ProductResponse

    @GET("/products")
    suspend fun getAllProducts(): ProductsResponse

    @PATCH("products/{id}")
    suspend fun updateProduct(@Path("id") id: String, @Body productUpdateDTO: UpdateProductDto): ProductResponse

    @DELETE("products/{id}")
    suspend fun deleteProduct(@Path("id") id: String): Unit
}