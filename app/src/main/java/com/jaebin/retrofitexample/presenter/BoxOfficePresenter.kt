package com.jaebin.retrofitexample.presenter

import com.jaebin.retrofitexample.KEY
import com.jaebin.retrofitexample.TARGET_DT
import com.jaebin.retrofitexample.contract.BoxOfficeAdapterContract
import com.jaebin.retrofitexample.contract.BoxOfficeContract
import com.jaebin.retrofitexample.contract.OnItemClick
import com.jaebin.retrofitexample.data.DailyBoxOffice
import com.jaebin.retrofitexample.data.source.MovieListRepository
import com.jaebin.retrofitexample.data.source.MovieListRepositoryImpl
import com.jaebin.retrofitexample.data.source.remote.MovieListDataSourceRepositoryImpl
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.java.KoinJavaComponent.inject

class BoxOfficePresenter():BoxOfficeContract.Presenter,OnItemClick,BoxOfficeContract.Model.OnSuccessListener,KoinComponent {
    private var view: BoxOfficeContract.View? = null
    private var adapterModel: BoxOfficeAdapterContract.Model? = null
    private var adapterView: BoxOfficeAdapterContract.View? = null
    private val movieListRepository: MovieListRepositoryImpl by inject()

   constructor(view: BoxOfficeContract.View?):this() {
        this.view = view

    }

    override fun requestMovieList() {
        movieListRepository.getMovieList(KEY, TARGET_DT,this)
    }


    override fun onDestroy() {
        view = null
    }

    override fun requestMovieDataFromApi() {
        requestMovieList()
    }

    override fun setMovieAdapterModel(model: BoxOfficeAdapterContract.Model) {
        this.adapterModel = model
    }

    override fun setMovieAdapterView(view: BoxOfficeAdapterContract.View) {
        this.adapterView = view
        this.adapterView?.setOnClickListener(this)
    }


    override fun onItemClick(pos: Int) {
        view?.showToast("${pos+1}번째 클릭")
    }

    override fun onSuccess(data: List<DailyBoxOffice>) {
        adapterModel?.setData(data)
        adapterView?.notifyAdapter()
    }

    override fun onFailure(errMsg: String) {
        view?.onResponseFailure(errMsg)
    }


}