package com.example.modul6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class AnimeAdapter(private val listAnime: ArrayList<Anime>)
    : RecyclerView.Adapter<AnimeAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_anime, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ListViewHolder, position: Int) {
        viewHolder.nameAnime.text = listAnime[position].id.toString()
        viewHolder.deskAnime.text = listAnime[position].name.toString()

        val img =listAnime[position].img
        Picasso.get().load(img).into(viewHolder.avatar)

        viewHolder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listAnime[viewHolder.adapterPosition])
        }
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var avatar  : ImageView = itemView.findViewById(R.id.card_image)
        var nameAnime : TextView = itemView.findViewById(R.id.card_id)
        var deskAnime : TextView = itemView.findViewById(R.id.card_text)
    }

    override fun getItemCount(): Int{
        return listAnime.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(data:Anime)
    }
}