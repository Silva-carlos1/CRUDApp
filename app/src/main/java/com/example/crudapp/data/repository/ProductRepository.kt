package com.example.crudapp.data.repository

import com.example.crudapp.data.api.ProductApiService
import com.example.crudapp.data.model.CreateProductDto
import com.example.crudapp.data.model.UpdateProductDto

class ProductRepository(private val productApiService: ProductApiService) {

    suspend fun getAllProducts() = productApiService.getAllProducts()

    suspend fun createProduct(product: CreateProductDto) = productApiService.createProduct(product)
}