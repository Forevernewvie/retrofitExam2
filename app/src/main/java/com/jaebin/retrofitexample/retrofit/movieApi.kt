package com.jaebin.retrofitexample.retrofit

interface movieApi {

    companion object{
        const val baseUrl = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json"
        const val key="154bc1716d28fb8a212340401c409a10"
        const val url ="http://www.kobis.or.kr"
        const val targetDt="20210401"
    }

}
