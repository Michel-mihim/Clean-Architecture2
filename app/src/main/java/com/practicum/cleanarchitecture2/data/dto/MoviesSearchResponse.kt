package com.practicum.cleanarchitecture2.data.dto

import com.practicum.cleanarchitecture2.domain.models.Movie

data class MoviesSearchResponse(val searchType: String,
                                val expression: String,
                                val results: List<MovieDto>) : Response()
