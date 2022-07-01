package com.paul.newsassignment

import android.app.Application
import com.paul.newsassignment.data.source.NewsRepository
import com.paul.newsassignment.util.ServiceLocator
import kotlin.properties.Delegates

class NewsApplication : Application() {

    val repository: NewsRepository
        get() = ServiceLocator.provideRepository(this)

    companion object {
        var instance: NewsApplication by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}