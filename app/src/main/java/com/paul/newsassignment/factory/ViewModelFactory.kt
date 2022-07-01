package com.paul.newsassignment.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.paul.newsassignment.data.source.NewsRepository
import com.paul.newsassignment.homefragment.HomeViewModel

class ViewModelFactory constructor(
    private val repository: NewsRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        with(modelClass) {
            when {
                isAssignableFrom(HomeViewModel::class.java) ->
                    HomeViewModel(repository)


                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}