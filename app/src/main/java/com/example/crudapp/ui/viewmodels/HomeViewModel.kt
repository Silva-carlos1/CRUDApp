package com.example.crudapp.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crudapp.data.model.CreateProductDto
import com.example.crudapp.data.model.UpdateProductDto
import com.example.crudapp.data.repository.ProductRepository
import com.example.crudapp.model.HomeState
import com.example.crudapp.model.Product
import kotlinx.coroutines.launch

class HomeViewModel(
    private val productRepository: ProductRepository
) : ViewModel() {
    var state by mutableStateOf(HomeState())
        private set
    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            try {
                val response = productRepository.getAllProducts()
                state = state.copy(
                    products = response.data
                )
            } catch (e: Exception) {
                Log.d("error: ", "$e")
            }
        }
    }

    fun setProductName(name: String) {
        state = state.copy(
            productName = name
        )
    }

    fun setProductPrice(price: String) {
        state = state.copy(
            productPrice = price
        )
    }

    fun editProduct(product: Product) {
        state = state.copy(
            productId = product.id,
            productName = product.name,
            productPrice = product.price.toString()
        )
    }

    fun deleteProduct(product: Product) {
        viewModelScope.launch {
            try {
                productRepository.deleteProduct(product.id)
            } catch (e: Exception) {
                println()
            }
            getProducts()
        }
    }

    fun createProduct() {
        val product =
            CreateProductDto(
                state.productName,
                state.productPrice.toDouble(),
            )
        viewModelScope.launch {
            try {
                if (state.productId == null) {
                    productRepository.createProduct(product)
                } else {
                    val updateProductDto = UpdateProductDto(
                        state.productName,
                        state.productPrice.toDouble()
                    )
                    productRepository.updateProduct(state.productId!!, updateProductDto)
                }
            } catch (e: Exception) {
                Log.e("ERROR", "Error creating or updating product")
            }
            getProducts()
        }
        state = state.copy(
            productName = "",
            productPrice = "",
            productId = null
        )
    }
}