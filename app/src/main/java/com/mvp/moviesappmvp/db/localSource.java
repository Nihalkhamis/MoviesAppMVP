package com.mvp.moviesappmvp.db;

import com.mvp.moviesappmvp.model.MovieModel;

import java.util.List;

import androidx.lifecycle.LiveData;

public interface localSource {
    void insertMovie(MovieModel movieModel);
    void deleteMovie(MovieModel movieModel);
    LiveData<List<MovieModel>> getAllStoredMovies();
}
