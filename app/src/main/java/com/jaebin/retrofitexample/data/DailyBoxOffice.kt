package com.jaebin.retrofitexample.data

import com.google.gson.annotations.SerializedName

data class DailyBoxOffice(

    @SerializedName("movieNm")
    val movieNm: String,
    @SerializedName("openDt")
    val openDt: String,
    @SerializedName("rank")
    val rank: String,

)