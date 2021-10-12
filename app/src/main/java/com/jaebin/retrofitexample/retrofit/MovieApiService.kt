package com.jaebin.retrofitexample.retrofit

import com.jaebin.retrofitexample.BASE_URL
import com.jaebin.retrofitexample.data.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET(BASE_URL)
    fun getMovieList(
        @Query("key") key: String,
        @Query("targetDt") targetDt: String
    ): Call<Result>

}