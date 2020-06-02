package com.example.data.movie

import com.example.domain.movie.model.Movie
import com.example.domain.movie.model.MovieDetail
import io.reactivex.Flowable

interface MovieCache {

    suspend fun getMovieById(imdbID: String): Movie

    suspend fun requestMovies(titleToSearchFor: String?): List<Movie>

    fun observeMovies(): Flowable<List<Movie>>

    suspend fun storeMovies(movies: List<Movie>)

    suspend fun storeMovieDetail(movieDetail: MovieDetail)
}