package com.paul.newsassignment.homefragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paul.newsassignment.data.MyResult
import com.paul.newsassignment.data.NewsData
import com.paul.newsassignment.data.source.NewsRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    private var _news = MutableLiveData<NewsData>()
    val news: LiveData<NewsData>
        get() = _news


    fun getNews() {
        viewModelScope.launch {
            val result = newsRepository.getNews()
            when (result) {
                is MyResult.Success -> {
                    _news.value = result.data ?: return@launch

                    Log.d("homeViewModel", "news result = ${result.data}")
                }
                is MyResult.Error -> {
                    Log.d("homeViewModel", "news result = ${result.exception}")
                }
                is MyResult.Fail -> {
                    Log.d("homeViewModel", "news result = ${result.error}")
                }
            }

        }
    }

}