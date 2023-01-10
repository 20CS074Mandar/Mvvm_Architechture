package com.smartherd.mvvm_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.smartherd.mvvm_app.api.ApiInterface
import com.smartherd.mvvm_app.api.ApiUtilities
import com.smartherd.mvvm_app.databinding.ActivityMainBinding
import com.smartherd.mvvm_app.repository.MemesRepository
import com.smartherd.mvvm_app.viewmodel.MemeViewModelFactory
import com.smartherd.mvvm_app.viewmodel.MemesViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var memesViewModel: MemesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val apiInterface = ApiUtilities.getInstance().create(ApiInterface::class.java)
        val memesRepository=MemesRepository(apiInterface)
        memesViewModel = ViewModelProvider(this,MemeViewModelFactory(memesRepository)).get(MemesViewModel::class.java)
        memesViewModel.memes.observe(this,{
//            Log.d("MainActivity","onCreate: ${it.toString()}")
//            println("It data recived :- ${it.toString()}")
            it.data.memes.iterator().forEach {meme->
                Log.d("Itertor","name ${meme.name}\nImage : ${meme.url}")
            }
        })
    }
}