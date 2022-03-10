package com.mvp.moviesappmvp.favmovies.presenter;

import com.mvp.moviesappmvp.model.MovieModel;

import java.util.List;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

public interface favPresenterInterface {
      void showAllStoredMovies(LifecycleOwner owner);
      void deleteMovie(MovieModel movieModel);
}
