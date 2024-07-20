package com.example.crudapp.data.model

import com.example.crudapp.model.Product

data class ProductResponse(
    val code: Int,
    val data: Product
)