package com.example.crudapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.crudapp.data.api.ProductApiService
import com.example.crudapp.data.repository.ProductRepository
import com.example.crudapp.ui.screens.HomeScreen
import com.example.crudapp.ui.theme.CrudAppTheme
import com.example.crudapp.ui.viewmodels.HomeViewModel
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val productRepository: ProductRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CrudAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    val viewModel = HomeViewModel(productRepository)
                    HomeScreen(viewModel = viewModel)
                }
            }
        }
    }
}