package com.example.modul5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnimeAdapter(private val listAnime: ArrayList<Anime>)
    : RecyclerView.Adapter<AnimeAdapter.ListViewHolder>() {
//    private lateinit var onItemClickCallback: onItemClickCallback
//    fun setOnItemClickCallback(onItemClickCallback: onItemClickCallback){
//        this.onItemClickCallback = onItemClickCallback
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_anime, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name,description,photo) = listAnime[position]
        holder.imgAnime.setImageResource(photo)
        holder.nameAnime.text = name
        holder.deskAnime.text = description
//        holder.itemView.setOnClickListener{
//            onItemClickCallback.onItemClicked(listAnime[holder.adapterPosition])
//        }
    }

    override fun getItemCount(): Int = listAnime.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imgAnime  : ImageView = itemView.findViewById(R.id.card_image)
        var nameAnime : TextView = itemView.findViewById(R.id.card_id)
        var deskAnime : TextView = itemView.findViewById(R.id.card_text)
    }

//    interface onItemClickCallback{
//        fun onItemClicked(data:Anime)
//    }
}