package com.smartherd.mvvm_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smartherd.mvvm_app.MainActivity
import com.smartherd.mvvm_app.R
import com.smartherd.mvvm_app.databinding.ActivityMainBinding
import com.smartherd.mvvm_app.model.Meme

class MemeAdapter(val context: Context) : RecyclerView.Adapter<MemeAdapter.MyViewHolder>() {

    private var memeList:List<Meme>?=null
    override fun getItemCount(): Int {
        return memeList?.size!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ActivityMainBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    }
    class MyViewHolder(val binding: ActivityMainBinding) :RecyclerView.ViewHolder(binding.root)
}