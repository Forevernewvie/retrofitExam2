package com.jaebin.retrofitexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jaebin.retrofitexample.data.BoxOfficeResult
import com.jaebin.retrofitexample.data.DailyBoxOffice
import com.jaebin.retrofitexample.data.Result
import com.jaebin.retrofitexample.databinding.ActivityMainBinding
import com.jaebin.retrofitexample.recycler.RecyclerAdapter
import com.jaebin.retrofitexample.retrofit.RetrofitClient
import com.jaebin.retrofitexample.retrofit.movieApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private var mBinding:ActivityMainBinding?=null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.recycle.layoutManager = LinearLayoutManager(this)


        val call: Call<Result> = RetrofitClient.service.getMovieList(movieApi.key, movieApi.targetDt)
        call.enqueue(
            object:Callback<Result>{
                override fun onResponse(call: Call<Result>, response: Response<Result>) {
                    val data: Result = response.body()!!
                    val boxOffice: BoxOfficeResult = data.boxOfficeResult
                    binding.recycle.adapter = RecyclerAdapter(boxOffice.dailyBoxOfficeList)
                    binding.recycle.setHasFixedSize(true)
                }

                override fun onFailure(call: Call<Result>, t: Throwable) {
                    Log.d("fail", "onFailure: 실패")
                }

            }
        )

    }



}








