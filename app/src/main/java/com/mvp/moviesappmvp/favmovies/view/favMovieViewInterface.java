package com.mvp.moviesappmvp.favmovies.view;

import com.mvp.moviesappmvp.model.MovieModel;

import java.util.List;

import androidx.lifecycle.LiveData;

public interface favMovieViewInterface {
    void deleteMovie(MovieModel movieModel);
   void getAllStoredMovies(List<MovieModel> movieModels);
}
