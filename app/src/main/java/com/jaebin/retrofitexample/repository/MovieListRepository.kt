package com.jaebin.retrofitexample.repository

import com.jaebin.retrofitexample.model.Result
import com.jaebin.retrofitexample.retrofit.MovieApiService
import retrofit2.Call

class MovieListRepository(private val service:MovieApiService) {

    fun getMovieList(key:String,targetDT:String): Call<Result>{
        return service.getMovieList(key,targetDT)
    }

}