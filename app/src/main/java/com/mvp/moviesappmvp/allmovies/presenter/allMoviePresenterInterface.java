package com.mvp.moviesappmvp.allmovies.presenter;

import com.mvp.moviesappmvp.model.MovieModel;

import java.util.ArrayList;

public interface allMoviePresenterInterface {
    void getMovies();
    void addToFav(MovieModel movieModel);
}
