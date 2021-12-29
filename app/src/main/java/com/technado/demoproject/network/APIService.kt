package com.technado.demoproject.network

import com.technado.demoproject.models.MovieModel
import retrofit2.Call

import retrofit2.http.GET

abstract class APIService {
    @GET("photos")
    abstract fun getMovieList(): Call<List<MovieModel?>?>?
}