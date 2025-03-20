package com.example.newsinshort.data.datasource

import com.example.newsinshort.data.entity.NewsResponse
import retrofit2.Response

interface NewsDataSource {

    fun getNewsHeadline(country :String) : Response<NewsResponse>
}