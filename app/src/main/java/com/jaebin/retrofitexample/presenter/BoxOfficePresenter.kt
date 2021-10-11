package com.jaebin.retrofitexample.presenter

import com.jaebin.retrofitexample.contract.BoxOfficeAdapterContract
import com.jaebin.retrofitexample.contract.BoxOfficeContract
import com.jaebin.retrofitexample.contract.OnItemClick
import com.jaebin.retrofitexample.model.BoxOfficeListModel
import com.jaebin.retrofitexample.model.DailyBoxOffice

class BoxOfficePresenter():BoxOfficeContract.Presenter,OnItemClick,BoxOfficeContract.Model.OnSuccessListener {
    private var view: BoxOfficeContract.View? = null
    private var model: BoxOfficeContract.Model? = null
    private var adapterModel: BoxOfficeAdapterContract.Model? = null
    private var adapterView: BoxOfficeAdapterContract.View? = null

   constructor(view: BoxOfficeContract.View?):this() {
        this.view = view
        this.model = BoxOfficeListModel()
    }

    override fun onDestroy() {
        view = null
    }

    override fun requestMovieDataFromApi() {
        model?.getBoxOfficeMovieList(this)
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