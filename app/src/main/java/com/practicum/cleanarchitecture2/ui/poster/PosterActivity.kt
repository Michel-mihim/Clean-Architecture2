package com.practicum.cleanarchitecture2.ui.poster

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.practicum.cleanarchitecture2.R

class PosterActivity : Activity() {
    private lateinit var poster: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poster)

        poster = findViewById(R.id.poster)
        val url = intent.extras?.getString("poster", "")

        Glide.with(applicationContext)
            .load(url)
            .into(poster)
    }
}