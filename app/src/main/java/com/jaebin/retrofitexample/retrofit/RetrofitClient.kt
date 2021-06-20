package com.jaebin.retrofitexample.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitClient {
       
    var okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(3, TimeUnit.SECONDS)
        .writeTimeout(3, TimeUnit.SECONDS)
        .build()

        private val retrofit:Retrofit = Retrofit.Builder()
            .baseUrl( movieApi.url)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        val service: RetroFitInterface =
            retrofit.create(RetroFitInterface::class.java)




}