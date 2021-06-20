package com.jaebin.retrofitexample.data

import com.google.gson.annotations.SerializedName

data class BoxOfficeResult(

    @SerializedName("dailyBoxOfficeList")
    val dailyBoxOfficeList: List<DailyBoxOffice>

)