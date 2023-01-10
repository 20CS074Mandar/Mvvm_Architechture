package com.smartherd.mvvm_app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smartherd.mvvm_app.model.Jokes
import com.smartherd.mvvm_app.repository.MemesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemesViewModel(private val memesRepository: MemesRepository): ViewModel() {

    //getting all memes from the repository

    init {
        viewModelScope.launch(Dispatchers.IO) {
            memesRepository.getMemes()
        }
    }

    val memes:LiveData<Jokes>
    get()=memesRepository.memes

}