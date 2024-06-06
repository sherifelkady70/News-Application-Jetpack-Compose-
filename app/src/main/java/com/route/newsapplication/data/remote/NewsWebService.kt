package com.route.newsapplication.data.remote

import com.route.newsapplication.data.remote.dto.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsWebService {
    @GET("everything")
    suspend fun getNews(
        @Query("page") page : Int,
        @Query("sources") sources : String,
        @Query("apikey") apikey : String
    ) : NewsResponse
}