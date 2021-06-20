package com.jaebin.retrofitexample.retrofit

interface movieApi {

    companion object{
        const val baseUrl = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json"
        const val key=""
        const val url ="http://www.kobis.or.kr"
        const val targetDt="20210401"
    }

}
