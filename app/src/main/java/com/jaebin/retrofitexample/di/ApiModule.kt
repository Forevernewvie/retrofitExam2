package com.jaebin.retrofitexample.di

import com.jaebin.retrofitexample.retrofit.MovieApiService
import org.koin.dsl.module
import retrofit2.Retrofit

val ApiModule = module {
    single<MovieApiService> (createdAtStart =false){
        get<Retrofit>().create(MovieApiService::class.java)
    }
}