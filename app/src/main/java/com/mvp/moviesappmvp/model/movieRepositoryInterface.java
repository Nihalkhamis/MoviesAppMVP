package com.mvp.moviesappmvp.model;

import com.mvp.moviesappmvp.network.networkDelegate;

import java.util.List;

import androidx.lifecycle.LiveData;

public interface movieRepositoryInterface {
   LiveData<List<MovieModel>> getStoredMovies();
  void getAllMovies(networkDelegate networkDelegate);
  void insertMovie(MovieModel movieModel);
  void deleteMovie(MovieModel movieModel);
}
