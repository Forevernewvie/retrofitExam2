package com.jaebin.retrofitexample.di

import com.jaebin.retrofitexample.repository.MovieListRepository
import org.koin.dsl.module

val RepositoryModule =module{

    factory{
        MovieListRepository(get())
    }

}