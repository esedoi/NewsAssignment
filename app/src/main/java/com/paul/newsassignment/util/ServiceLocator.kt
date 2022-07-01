package com.paul.newsassignment.util

import android.content.Context
import com.paul.newsassignment.data.source.DefaultNewsRepository
import com.paul.newsassignment.data.source.NewsRepository
import com.paul.newsassignment.data.source.remote.NewsRemoteDataSource

object ServiceLocator {

    var repository: NewsRepository? = null

    fun provideRepository(context: Context): NewsRepository {
        synchronized(this) {
            return repository
                ?: repository
                ?: createWeatherRepository(context)
        }
    }

    private fun createWeatherRepository(context: Context): NewsRepository {
        return DefaultNewsRepository(
            NewsRemoteDataSource
        )
    }
}