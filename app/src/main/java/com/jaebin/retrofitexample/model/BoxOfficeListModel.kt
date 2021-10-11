package com.jaebin.retrofitexample.model

import android.util.Log
import android.widget.Toast
import com.jaebin.retrofitexample.KEY
import com.jaebin.retrofitexample.TARGET_DT
import com.jaebin.retrofitexample.contract.BoxOfficeContract
import com.jaebin.retrofitexample.myApp
import com.jaebin.retrofitexample.recycler.BoxOfficeAdapter
import com.jaebin.retrofitexample.repository.MovieListRepository
import org.koin.android.ext.koin.ERROR_MSG
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class BoxOfficeListModel : BoxOfficeContract.Model,KoinComponent {

    private val model:MovieListRepository by inject()
    var movies: List<DailyBoxOffice> = arrayListOf()

    override fun getBoxOfficeMovieList(onSuccessListener: BoxOfficeContract.Model.OnSuccessListener) {
        model.getMovieList(KEY,TARGET_DT).enqueue(object: retrofit2.Callback<Result>{
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                if(response.isSuccessful){
                    val data: Result = response.body()!!
                    val boxOffice: BoxOfficeResult = data.boxOfficeResult
                    movies = boxOffice.dailyBoxOfficeList
                    onSuccessListener.onSuccess(movies)
                }
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                onSuccessListener.onFailure("${t.message}")
                Log.d(ERROR_MSG, "onFailure:${t.stackTrace} ")
            }
        })
    }
}