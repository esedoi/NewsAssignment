package com.paul.newsassignment.data.source

import com.paul.newsassignment.data.MyResult
import com.paul.newsassignment.data.NewsData


class DefaultNewsRepository (private val newsDataSource: NewsDataSource) :
    NewsRepository {

    override suspend fun getNews(): MyResult<NewsData> {
        return newsDataSource.getNews()
    }
}