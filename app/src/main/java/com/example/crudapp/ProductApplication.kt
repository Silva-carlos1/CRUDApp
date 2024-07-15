package com.example.crudapp

import android.app.Application
import com.example.crudapp.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ProductApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@ProductApplication)
            modules(
                networkModule
            )
        }
    }
}