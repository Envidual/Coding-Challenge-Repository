package com.example.remote.movie

import com.example.data.movie.MovieRemote
import com.example.domain.movie.model.Movie
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MovieRemoteImpl @Inject constructor(
    private val movieService: MovieService
): MovieRemote{


    override suspend fun fetchImages(
    ): List<Movie> {
        return movieService.getCurrentMovie(
            title = "Avengers",
            key = "3e6675f5",
            plot = "Whatever"
        ).movies
            .map {
                Movie(it.released, it.poster, it.plot, it.title, it.imdbID)
            }
    }
}