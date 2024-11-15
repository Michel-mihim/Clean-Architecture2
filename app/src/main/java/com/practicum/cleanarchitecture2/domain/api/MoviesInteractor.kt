package com.practicum.cleanarchitecture2.domain.api

import com.practicum.cleanarchitecture2.domain.models.Movie

interface MoviesInteractor {
    fun searchMovies(expression: String, consumer: MoviesConsumer)

    interface MoviesConsumer {
        fun consume(foundMovies: List<Movie>)
    }
}