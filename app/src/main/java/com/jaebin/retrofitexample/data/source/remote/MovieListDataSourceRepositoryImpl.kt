package com.jaebin.retrofitexample.data.source.remote

import android.util.Log
import com.jaebin.retrofitexample.KEY
import com.jaebin.retrofitexample.TARGET_DT
import com.jaebin.retrofitexample.contract.BoxOfficeContract
import com.jaebin.retrofitexample.data.BoxOfficeResult
import com.jaebin.retrofitexample.data.Result
import com.jaebin.retrofitexample.retrofit.MovieApiService
import org.koin.android.ext.koin.ERROR_MSG
import org.koin.core.component.KoinComponent

import retrofit2.Call
import retrofit2.Response

class MovieListDataSourceRepositoryImpl(private val service: MovieApiService):  KoinComponent,
    MovieListDataSource {

    override fun getBoxOfficeMovieList(
        key: String,
        targetDT: String,
        onSuccessListener: BoxOfficeContract.Model.OnSuccessListener
    ) {

        service.getMovieList(KEY, TARGET_DT).enqueue(object: retrofit2.Callback<Result>{
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                if(response.isSuccessful){
                    val data: Result = response.body()!!
                    val boxOffice: BoxOfficeResult = data.boxOfficeResult
                    onSuccessListener.onSuccess( boxOffice.dailyBoxOfficeList)
                }
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                onSuccessListener.onFailure("${t.message}")
                Log.d(ERROR_MSG, "onFailure:${t.stackTrace} ")
            }
        })
    }

}