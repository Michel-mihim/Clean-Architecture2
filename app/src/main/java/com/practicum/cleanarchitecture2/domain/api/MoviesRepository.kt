package com.practicum.cleanarchitecture2.domain.api

import com.practicum.cleanarchitecture2.domain.models.Movie

interface MoviesRepository {
    fun searchMovies(expression: String): List<Movie>
}