package com.technado.demoproject.view_model

import androidx.lifecycle.MutableLiveData
import com.technado.demoproject.models.MovieModel
import com.technado.demoproject.network.APIService
import com.technado.demoproject.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MovieListViewModel {
    private var movieList: MutableLiveData<List<MovieModel>?>? = null

    constructor(movieList: MutableLiveData<List<MovieModel>?>?) {
        this.movieList = movieList
    }

    fun getMoviesListObserver(): MutableLiveData<List<MovieModel>?>? {
        return movieList
    }

    fun makeApiCall() {
        val apiService: APIService = RetrofitInstance.getRetrofit()!!.create()
        val call: Call<List<MovieModel?>?>? = apiService.getMovieList()
        call?.enqueue(object : Callback<List<MovieModel?>?> {
            override fun onResponse(call: Call<List<MovieModel?>?>?, response: Response<List<MovieModel?>?>) {
                movieList!!.postValue(response.body() as List<MovieModel>?)
            }

            override fun onFailure(call: Call<List<MovieModel?>?>?, t: Throwable?) {
                movieList!!.postValue(null)
            }
        })
    }
}