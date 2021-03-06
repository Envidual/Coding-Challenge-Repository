package com.example.data.tmdbmovie

import com.example.domain.tmdbmovie.model.moviedetail.Credits
import com.example.domain.tmdbmovie.model.movielist.Result
import com.example.domain.tmdbmovie.model.moviedetail.TMDbMovieDetail
import com.example.domain.tmdbmovie.model.tvdetail.TMDbTvDetail
import com.example.domain.tmdbmovie.model.tvlist.TvListResult

interface TMDbMovieRemote {

    suspend fun fetchTMDbMovies(tmdbTitleToSearchFor: String): List<Result>

    suspend fun fetchTMDbMovieDetail(id: Int): TMDbMovieDetail

    suspend fun fetchTMDbCredits(id: Int): Credits

    suspend fun fetchTMDbTvList(tmdbTvToSearchFor: String): List<TvListResult>

    suspend fun fetchTMDbTvDetail(id: Int): TMDbTvDetail
}