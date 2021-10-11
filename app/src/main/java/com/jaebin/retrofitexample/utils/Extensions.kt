package com.jaebin.retrofitexample

import android.app.Activity
import android.widget.Toast

fun Activity.showToastMsg(msg:String){
    Toast.makeText(myApp.instance.applicationContext,msg,Toast.LENGTH_SHORT).show()
}