package com.practicum.cleanarchitecture2.domain.impl

import com.practicum.cleanarchitecture2.domain.api.MoviesInteractor
import com.practicum.cleanarchitecture2.domain.api.MoviesRepository
import java.util.concurrent.Executors

class MoviesInteractorImpl(private val repository: MoviesRepository) : MoviesInteractor {
    private  val executor = Executors.newCachedThreadPool()

    override fun searchMovies(expression: String, consumer: MoviesInteractor.MoviesConsumer) {
        executor.execute {
            consumer.consume(repository.searchMovies(expression))
        }
    }
}