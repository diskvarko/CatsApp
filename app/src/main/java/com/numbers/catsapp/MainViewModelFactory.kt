package com.example.retrofittest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.numbers.catsapp.CatViewModel
import com.numbers.catsapp.Repository


class MainViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CatViewModel(repository) as T
    }
}