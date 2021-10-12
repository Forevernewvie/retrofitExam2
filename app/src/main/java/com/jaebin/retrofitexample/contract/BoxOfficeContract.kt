package com.jaebin.retrofitexample.contract

import com.jaebin.retrofitexample.data.DailyBoxOffice

interface BoxOfficeContract {

    interface Model{
        interface OnSuccessListener{
            fun onSuccess(data : List<DailyBoxOffice>)
            fun onFailure(errMsg: String)
        }


    }

    interface View{
        fun showToast(msg:String)
        fun onResponseFailure(errMsg:String)
    }

    interface Presenter{
        fun requestMovieList()
        fun onDestroy()
        fun requestMovieDataFromApi()
        fun setMovieAdapterModel(model :BoxOfficeAdapterContract.Model)
        fun setMovieAdapterView(view : BoxOfficeAdapterContract.View)
    }


}