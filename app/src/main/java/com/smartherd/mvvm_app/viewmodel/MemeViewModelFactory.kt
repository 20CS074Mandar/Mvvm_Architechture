package com.smartherd.mvvm_app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.smartherd.mvvm_app.repository.MemesRepository

class MemeViewModelFactory (private  val memesRepository: MemesRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MemesViewModel(memesRepository)as T
    }
}