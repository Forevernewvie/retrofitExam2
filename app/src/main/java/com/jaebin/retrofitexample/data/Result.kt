package com.jaebin.retrofitexample.data

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("boxOfficeResult")
    val boxOfficeResult: BoxOfficeResult
)