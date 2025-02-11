package com.practicum.cleanarchitecture2.data

import com.practicum.cleanarchitecture2.data.dto.MoviesSearchRequest
import com.practicum.cleanarchitecture2.data.dto.MoviesSearchResponse
import com.practicum.cleanarchitecture2.domain.api.MoviesRepository
import com.practicum.cleanarchitecture2.domain.models.Movie

class MoviesRepositoryImpl(private val networkClient: NetworkClient) : MoviesRepository {
    override fun searchMovies(expression: String): List<Movie> {
        val response = networkClient.doRequest(MoviesSearchRequest(expression))
        if (response.resultCode == 200) {
            return (response as MoviesSearchResponse).results.map {
                Movie(it.id, it.resultType, it.image, it.title, it.description)
            }
        } else (return emptyList())
    }
}