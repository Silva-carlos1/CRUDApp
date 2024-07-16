package com.example.crudapp.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crudapp.data.repository.ProductRepository
import com.example.crudapp.model.HomeState
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
}