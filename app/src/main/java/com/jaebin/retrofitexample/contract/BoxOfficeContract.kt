package com.jaebin.retrofitexample.contract

import com.jaebin.retrofitexample.model.DailyBoxOffice

interface BoxOfficeContract {

    interface Model{
        interface OnSuccessListener{
            fun onSuccess(data : List<DailyBoxOffice>)
            fun onFailure(errMsg: String)
        }

        fun getBoxOfficeMovieList(onSuccessListener: OnSuccessListener)

    }

    interface View{
        fun showToast(msg:String)
        fun onResponseFailure(errMsg:String)
    }

    interface Presenter{
        fun onDestroy()
        fun requestMovieDataFromApi()
        fun setMovieAdapterModel(model :BoxOfficeAdapterContract.Model)
        fun setMovieAdapterView(view : BoxOfficeAdapterContract.View)
    }


}