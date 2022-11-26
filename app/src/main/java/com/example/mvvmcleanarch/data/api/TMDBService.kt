package com.example.mvvmcleanarch.data.api

import com.example.mvvmcleanarch.data.model.artist.ArtistList
import com.example.mvvmcleanarch.data.model.movie.MovieList
import com.example.mvvmcleanarch.data.model.tvShow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    @GET(value = "movie/popular")
    suspend fun getPopularMovies(@Query(value = "api_key")apikey:String): Response<MovieList>

    @GET(value = "tv/popular")
    suspend fun getPopularTvShows(@Query(value = "api_key")apikey:String): Response<TvShowList>

    @GET(value = "person/popular")
    suspend fun getPopularArtists(@Query(value = "api_key")apikey:String): Response<ArtistList>
}