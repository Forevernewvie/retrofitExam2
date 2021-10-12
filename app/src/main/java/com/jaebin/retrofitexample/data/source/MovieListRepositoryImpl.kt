package com.jaebin.retrofitexample.data.source

import com.jaebin.retrofitexample.contract.BoxOfficeContract
import com.jaebin.retrofitexample.data.source.remote.MovieListDataSourceRepositoryImpl
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class MovieListRepositoryImpl : MovieListRepository,KoinComponent {

    private val movieRemoteDataSource: MovieListDataSourceRepositoryImpl by inject()

    override fun getMovieList(key: String, targetDT: String, onSuccessListener: BoxOfficeContract.Model.OnSuccessListener) {
        movieRemoteDataSource.getBoxOfficeMovieList(key,targetDT,onSuccessListener)
    }


}