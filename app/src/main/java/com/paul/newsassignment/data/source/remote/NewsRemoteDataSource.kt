package com.paul.newsassignment.data.source.remote

import com.paul.newsassignment.data.MyResult
import com.paul.newsassignment.data.NewsData
import com.paul.newsassignment.data.source.NewsDataSource
import com.paul.newsassignment.network.NewsApi

object NewsRemoteDataSource: NewsDataSource {


    override suspend fun getNews(): MyResult<NewsData> {

        return try {
            val result = NewsApi.retrofitService.getNews()
            MyResult.Success(result)

        }catch (e:Exception){
            MyResult.Error(e)
        }

    }
}