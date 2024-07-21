package com.example.crudapp.ui.screens

import android.util.Log

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.crudapp.ui.components.ProductItem
import com.example.crudapp.ui.viewmodels.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel
) {
    val state = viewModel.state
    Log.d("HomeScreen", "$viewModel.get")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp),

    ) {
        OutlinedTextField(
            value = state.productName,
            onValueChange = { viewModel.setProductName(it) },
            label = { Text("Product Name") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = state.productPrice,
            onValueChange = { viewModel.setProductPrice(it) },
            label = { Text("Product Price") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )

        Button(
            onClick = { viewModel.createProduct() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Add produto")
        }



        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(state.products) {
                ProductItem(
                    product = it,
                    onEdit = {
                    viewModel.editProduct(it)
                },
                    onDelete = {
                        viewModel.deleteProduct(it)
                    },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
    }
}