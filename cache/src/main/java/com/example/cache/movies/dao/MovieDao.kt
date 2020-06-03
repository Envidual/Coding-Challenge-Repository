package com.example.cache.movies.dao

import androidx.room.*
import com.example.cache.movies.model.MovieAndRatings
import com.example.cache.movies.model.RoomMovie
import io.reactivex.Flowable

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie WHERE id =:imdbID")
    suspend fun getMovieByImdbID(imdbID: String): RoomMovie

    @Query("SELECT * FROM movie WHERE title LIKE :titleToSearchFor")
    suspend fun getMoviesForTitle(titleToSearchFor: String): List<RoomMovie>

    @Query("SELECT * FROM movie")
    fun observeMovies(): Flowable<List<RoomMovie>>

    //Observe one movie
    @Query("SELECT * FROM movie WHERE id =:imdbID")
    fun observeMovieDetail(imdbID: String): Flowable<MovieAndRatings>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllSuspend(entities: List<RoomMovie>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOneSuspend(entities: RoomMovie)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllIgnore(entities: List<RoomMovie>)

    @Transaction
    @Query("SELECT * from movie")
    fun getMovieAndRatings(): List<MovieAndRatings>
}

