package com.jaebin.retrofitexample.data.source.remote

import com.jaebin.retrofitexample.contract.BoxOfficeContract

interface MovieListDataSource {
    fun getBoxOfficeMovieList(
        key:String,
        targetDT:String,
        onSuccessListener: BoxOfficeContract.Model.OnSuccessListener
    )
}