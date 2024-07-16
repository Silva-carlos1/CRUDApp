package com.example.crudapp.data.model

import com.example.crudapp.model.Product

data class ProductsResponse(
    val code: Int,
    val data: ArrayList<Product>
)