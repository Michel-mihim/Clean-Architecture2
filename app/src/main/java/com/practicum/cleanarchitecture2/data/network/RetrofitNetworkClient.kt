package com.practicum.cleanarchitecture2.data.network

import com.practicum.cleanarchitecture2.data.NetworkClient
import com.practicum.cleanarchitecture2.data.dto.MoviesSearchRequest
import com.practicum.cleanarchitecture2.data.dto.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitNetworkClient : NetworkClient {
    private val imdbBaseUrl = "https://tv-api.com"

    private val retrofit = Retrofit.Builder()
        .baseUrl(imdbBaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val imdbService = retrofit.create(IMDbApiService::class.java)

    override fun doRequest(dto: Any): Response {
        if (dto is MoviesSearchRequest) {
            val resp = imdbService.searchMovies(dto.expression).execute()
            val body = resp.body()?: Response()
            return body.apply { resultCode = resp.code() }
        } else {
            return Response().apply { resultCode = 400 }
        }
    }
}