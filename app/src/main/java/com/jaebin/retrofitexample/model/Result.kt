package com.jaebin.retrofitexample.model

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("boxOfficeResult")
    val boxOfficeResult: BoxOfficeResult
)