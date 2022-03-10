package com.mvp.moviesappmvp.allmovies.view;

import com.mvp.moviesappmvp.model.MovieModel;

import java.util.ArrayList;

public interface allMovieViewInterface {
    void showData(ArrayList<MovieModel> movieModels);
    void addMovie(MovieModel movieModel);
}
