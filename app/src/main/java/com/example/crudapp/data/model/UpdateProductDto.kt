package com.example.crudapp.data.model

data class UpdateProductDto(
    val name: String? = null,
    val price: Double? = null,
    val quantity: Int? = null
)
