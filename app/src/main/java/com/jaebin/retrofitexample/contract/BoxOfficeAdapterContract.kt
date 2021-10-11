package com.jaebin.retrofitexample.contract

import android.widget.AdapterView
import com.jaebin.retrofitexample.model.DailyBoxOffice

interface BoxOfficeAdapterContract {

    interface View{
        fun notifyAdapter()
        fun setOnClickListener(clickListener: OnItemClick)
    }

    interface Model{
        fun setData(contents:List<DailyBoxOffice>)
        fun getData(pos:Int):DailyBoxOffice
    }

}