package com.mvp.moviesappmvp.allmovies.presenter;

import android.util.Log;

import com.mvp.moviesappmvp.allmovies.view.allMovieViewInterface;
import com.mvp.moviesappmvp.model.MovieModel;
import com.mvp.moviesappmvp.model.movieRepositoryInterface;
import com.mvp.moviesappmvp.network.networkDelegate;

import java.util.ArrayList;

public class AllMoviePresenter implements allMoviePresenterInterface, networkDelegate {

    allMovieViewInterface allMovieViewInterface;
    movieRepositoryInterface movieRepositoryInterface;

    public AllMoviePresenter(allMovieViewInterface allMovieViewInterface, movieRepositoryInterface movieRepositoryInterface) {
        this.allMovieViewInterface = allMovieViewInterface;
        this.movieRepositoryInterface = movieRepositoryInterface;
    }

    @Override
    public void getMovies() {
         //calling getMovies method from repo is missing
        movieRepositoryInterface.getAllMovies(this);
    }

    @Override
    public void addToFav(MovieModel movieModel) {
        //calling insertMovie method from repo is missing
        movieRepositoryInterface.insertMovie(movieModel);
    }

    @Override
    public void onSuccessResult(ArrayList<MovieModel> movieModels) {
        allMovieViewInterface.showData(movieModels);
    }

    @Override
    public void onFailureResult(String errorMsg) {
        Log.d("TAG", "onFailureResult: " + errorMsg);
    }
}
