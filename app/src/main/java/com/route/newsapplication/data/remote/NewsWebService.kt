package com.route.newsapplication.data.remote

import com.route.newsapplication.data.remote.dto.NewsResponse
import com.route.newsapplication.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsWebService {
    @GET("everything")
    suspend fun getNews(
        @Query("sources") sources: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse
}