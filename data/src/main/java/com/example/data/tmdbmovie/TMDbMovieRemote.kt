package com.example.data.tmdbmovie

import com.example.domain.tmdbmovie.model.Result
import com.example.domain.tmdbmovie.model.TMDbMovieDetail

interface TMDbMovieRemote {

    suspend fun fetchTMDbMovies(tmdbTitleToSearchFor: String): List<Result>

    suspend fun fetchTMDbMovieDetail(id: Int): TMDbMovieDetail
}