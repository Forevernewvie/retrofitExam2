package com.jaebin.retrofitexample

import android.app.Application
import com.jaebin.retrofitexample.di.ApiModule
import com.jaebin.retrofitexample.di.NetworkModule
import com.jaebin.retrofitexample.di.RepositoryModule
import com.jaebin.retrofitexample.di.AdapterModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class myApp :Application(){

    companion object{
        lateinit var instance : myApp
        private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        startKoin{
            androidContext(this@myApp)
            modules(listOf(NetworkModule, ApiModule, RepositoryModule, AdapterModule))
        }

    }


}