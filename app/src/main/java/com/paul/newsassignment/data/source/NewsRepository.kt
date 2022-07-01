package com.paul.newsassignment.data.source

import com.paul.newsassignment.data.MyResult
import com.paul.newsassignment.data.NewsData

interface NewsRepository {

    suspend fun getNews(): MyResult<NewsData>
}