package com.jaebin.retrofitexample.di

import com.jaebin.retrofitexample.recycler.BoxOfficeAdapter
import com.jaebin.retrofitexample.retrofit.MovieApiService
import org.koin.dsl.module
import retrofit2.Retrofit

val AdapterModule = module {
    single {
        BoxOfficeAdapter()
    }
}