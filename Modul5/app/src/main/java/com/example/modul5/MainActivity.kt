package com.example.modul5

import android.app.Activity
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.modul5.databinding.ActivityMainBinding
import com.example.modul5.databinding.ItemAnimeBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Anime>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list.addAll(listAnime)
        showRecyclerList()
    }

    private val listAnime: ArrayList<Anime>
    get(){
        val dataName = resources.getStringArray(R.array.anime1)
        val dataDescription = resources.getStringArray(R.array.anime2)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listAnime = ArrayList<Anime>()

        for(i in dataName.indices){
            val anime = Anime(dataName[i],dataDescription[i],dataPhoto.getResourceId(i, -1))
            listAnime.add(anime)
        }
        return listAnime
    }

    private fun showRecyclerList(){
        if(applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            binding.listAnime.layoutManager = GridLayoutManager(this,2)
        } else{
            binding.listAnime.layoutManager = LinearLayoutManager(this)
        }

        val adapter = AnimeAdapter(list)
        binding.listAnime.adapter = adapter
//        adapter.setOnItemClickCallback(object :AnimeAdapter.On)
    }
}

// Recycle View untuk menampilkan isi dari item yang berulang ketika discroll ke arah yang dituju