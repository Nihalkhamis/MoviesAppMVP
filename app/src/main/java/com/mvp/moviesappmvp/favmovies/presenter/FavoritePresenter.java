package com.mvp.moviesappmvp.favmovies.presenter;

import com.mvp.moviesappmvp.favmovies.view.favMovieViewInterface;
import com.mvp.moviesappmvp.model.MovieModel;
import com.mvp.moviesappmvp.model.movieRepositoryInterface;

import java.util.List;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

public class FavoritePresenter implements favPresenterInterface{

    favMovieViewInterface favMovieViewInterface;
   movieRepositoryInterface movieRepositoryInterface;

    public FavoritePresenter(favMovieViewInterface favMovieViewInterface, movieRepositoryInterface movieRepositoryInterface) {
        this.favMovieViewInterface = favMovieViewInterface;
        this.movieRepositoryInterface = movieRepositoryInterface;
    }

    @Override
    public void showAllStoredMovies(LifecycleOwner owner) {
       movieRepositoryInterface.getStoredMovies().observe(owner, new Observer<List<MovieModel>>() {
           @Override
           public void onChanged(List<MovieModel> movieModels) {
               favMovieViewInterface.getAllStoredMovies(movieModels);
           }
       });
    }

    @Override
    public void deleteMovie(MovieModel movieModel) {
       movieRepositoryInterface.deleteMovie(movieModel);
    }
}
