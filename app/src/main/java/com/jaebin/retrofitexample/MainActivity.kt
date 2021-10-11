package com.jaebin.retrofitexample

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jaebin.retrofitexample.contract.BoxOfficeContract
import com.jaebin.retrofitexample.databinding.ActivityMainBinding
import com.jaebin.retrofitexample.presenter.BoxOfficePresenter
import com.jaebin.retrofitexample.recycler.BoxOfficeAdapter
import org.koin.android.ext.android.inject
import org.koin.core.component.inject
import org.koin.java.KoinJavaComponent.inject


class MainActivity : AppCompatActivity(),BoxOfficeContract.View, View.OnClickListener {
    private var mBinding:ActivityMainBinding?=null
    private val binding get() = mBinding!!

    private var moviePresenter: BoxOfficePresenter? = null
    private val movieAdapter : BoxOfficeAdapter by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()

    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding=null
    }

    private fun initUI(){
        binding.btn.setOnClickListener(this)
        binding.recycle.layoutManager = LinearLayoutManager(this)
        binding.recycle.setHasFixedSize(true)
        binding.recycle.adapter = movieAdapter
        moviePresenter = BoxOfficePresenter(this)
        moviePresenter?.setMovieAdapterView(movieAdapter)
        moviePresenter?.setMovieAdapterModel(movieAdapter)

    }

    override fun showToast(msg: String) {
        this.showToastMsg(msg)
    }

    override fun onResponseFailure(errMsg: String) {
        this.showToastMsg(errMsg)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id){
                binding.btn.id ->
                    moviePresenter?.requestMovieDataFromApi()
            }
        }
    }


}








