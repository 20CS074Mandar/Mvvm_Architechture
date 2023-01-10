package com.smartherd.mvvm_app.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.smartherd.mvvm_app.api.ApiInterface
import com.smartherd.mvvm_app.model.Jokes

class MemesRepository(private  val apiInterface: ApiInterface) {
    private val memesLiveData = MutableLiveData<Jokes>()
    val memes:LiveData<Jokes>
    get()=memesLiveData
    suspend fun getMemes(){
        val result=apiInterface.getJokes()

        if(result.body()!=null){
            memesLiveData.postValue(result.body())
        }

    }
}