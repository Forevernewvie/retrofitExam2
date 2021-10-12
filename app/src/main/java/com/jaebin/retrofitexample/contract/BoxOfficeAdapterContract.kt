package com.jaebin.retrofitexample.contract

import com.jaebin.retrofitexample.data.DailyBoxOffice

interface BoxOfficeAdapterContract {

    interface View{
        fun notifyAdapter()
        fun setOnClickListener(clickListener: OnItemClick)
    }

    interface Model{
        fun setData(contents:List<DailyBoxOffice>)
        fun getData(pos:Int): DailyBoxOffice
    }

}