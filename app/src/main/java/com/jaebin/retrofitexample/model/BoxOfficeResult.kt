package com.jaebin.retrofitexample.model

import com.google.gson.annotations.SerializedName
import com.jaebin.retrofitexample.contract.BoxOfficeContract

data class BoxOfficeResult(
    @SerializedName("dailyBoxOfficeList")
    val dailyBoxOfficeList: List<DailyBoxOffice>)

