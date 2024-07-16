package com.example.crudapp.di

import com.example.crudapp.data.repository.ProductRepository
import com.example.crudapp.ui.viewmodels.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { ProductRepository(get()) }
    viewModel { HomeViewModel(get()) }
}