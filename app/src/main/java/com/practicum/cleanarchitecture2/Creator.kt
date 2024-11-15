package com.practicum.cleanarchitecture2

import com.practicum.cleanarchitecture2.data.MoviesRepositoryImpl
import com.practicum.cleanarchitecture2.data.network.RetrofitNetworkClient
import com.practicum.cleanarchitecture2.domain.api.MoviesInteractor
import com.practicum.cleanarchitecture2.domain.api.MoviesRepository
import com.practicum.cleanarchitecture2.domain.impl.MoviesInteractorImpl

object Creator {
    private  fun getMoviesRepository(): MoviesRepository {
        return MoviesRepositoryImpl(RetrofitNetworkClient())
    }

    fun provideMoviesInteractor(): MoviesInteractor {
        return MoviesInteractorImpl(getMoviesRepository())
    }
}