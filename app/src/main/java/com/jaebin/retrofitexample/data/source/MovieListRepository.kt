package com.jaebin.retrofitexample.data.source

import com.jaebin.retrofitexample.contract.BoxOfficeContract

interface MovieListRepository {
    fun getMovieList(key:String,targetDT:String, onSuccessListener: BoxOfficeContract.Model.OnSuccessListener)
}