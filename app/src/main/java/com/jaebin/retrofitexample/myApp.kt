package com.jaebin.retrofitexample

import android.app.Application

class myApp :Application(){

    companion object{
        lateinit var instance : myApp
        private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }


}