package com.practicum.cleanarchitecture2.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.practicum.cleanarchitecture2.R
import com.practicum.cleanarchitecture2.domain.models.Movie

class MovieViewHolder(parent: ViewGroup) :
    RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_movie, parent, false)) {

    private var cover: ImageView = itemView.findViewById(R.id.cover)
    private var title: TextView = itemView.findViewById(R.id.title)
    private var description: TextView = itemView.findViewById(R.id.description)

    fun bind(movie: Movie) {
        Glide.with(itemView)
            .load(movie.image)
            .into(cover)

        title.text = movie.title
        description.text = movie.description
    }
}