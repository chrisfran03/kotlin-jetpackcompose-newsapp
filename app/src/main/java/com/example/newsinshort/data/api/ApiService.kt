package com.example.newsinshort.data.api

import com.example.newsinshort.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("v2/top-headlines")
    suspend fun getNewsHeadline(
        @Query("country") country :String,
        @Query("apiKey") apiKey:String = "aa9f1049206b49a9a7a6db69fa04c6a0"
    ) : Response<NewsResponse>
}

//https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=