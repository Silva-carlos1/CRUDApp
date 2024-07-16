package com.example.crudapp.data.repository

import com.example.crudapp.data.api.ProductApiService

class ProductRepository(private val productApiService: ProductApiService) {

    suspend fun getAllProducts() = productApiService.getAllProducts()

}