package com.mvp.moviesappmvp.network;

import com.mvp.moviesappmvp.model.MovieModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface movieService {
    @GET("json/movies.json")
    Call<ArrayList<MovieModel>> getAllMovies();
}
