package com.jaebin.retrofitexample.di

import com.jaebin.retrofitexample.data.source.MovieListRepository
import com.jaebin.retrofitexample.data.source.MovieListRepositoryImpl
import com.jaebin.retrofitexample.data.source.remote.MovieListDataSourceRepositoryImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val RepositoryModule =module{

    single { MovieListRepositoryImpl() } bind MovieListRepository::class


    factory{
        MovieListDataSourceRepositoryImpl(get())
    }

}