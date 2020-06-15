package com.example.data.tmdbmovie

import com.example.domain.tmdbmovie.TMDbMovieRepository
import com.example.domain.tmdbmovie.model.Result
import com.example.domain.tmdbmovie.model.TMDbMovieDetail
import io.reactivex.Flowable
import javax.inject.Inject

class TMDbMovieRepoImpl @Inject constructor(
    private val tmDbMovieRemote: TMDbMovieRemote,
    private val tmDbMovieCache: TMDbMovieCache
) : TMDbMovieRepository {
    override suspend fun getTMDbMovieById(id: String): Result {
        return requestTMDbMovies(null).first { it.id.toString() == id }
    }

    override suspend fun observeTMDbMovies(): Flowable<List<Result>> {
        TODO("Not yet implemented")
    }

    override suspend fun requestTMDbMovies(tmdbTitleToSearchFor: String?): List<Result> {
        return tmDbMovieCache.requestTMDbMovies(tmdbTitleToSearchFor)
    }

    override suspend fun storeTMDbMovies(tmdbMovies: List<Result>) {
        return tmDbMovieCache.storeTMDbMovies(tmdbMovies)
    }

    override suspend fun fetchTMDbMovieDetail(id: Int): TMDbMovieDetail {
        return tmDbMovieRemote.fetchTMDbMovieDetail(id)
    }

    override suspend fun storeTMDbMovieDetail(tmDbMovieDetail: TMDbMovieDetail) {
        TODO("Not yet implemented")
    }

    override fun observeTMDbMovieDetail(id: String): Flowable<TMDbMovieDetail> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchTMDbMovies(tmdbTitleToSearchFor: String): List<Result> {
        return tmDbMovieRemote.fetchTMDbMovies(tmdbTitleToSearchFor)
    }
}