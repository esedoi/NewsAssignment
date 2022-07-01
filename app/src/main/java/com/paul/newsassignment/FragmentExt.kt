package com.paul.newsassignment

import androidx.fragment.app.Fragment
import com.paul.newsassignment.factory.ViewModelFactory

fun Fragment.getVmFactory(): ViewModelFactory {
    val repository = (requireContext().applicationContext as NewsApplication).repository
    return ViewModelFactory(repository)
}