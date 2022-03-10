package com.mvp.moviesappmvp.db;

import android.content.Context;
import android.util.Log;

import com.mvp.moviesappmvp.model.MovieModel;

import java.util.List;

import androidx.lifecycle.LiveData;

public class ConcreteLocalSource implements localSource {
    private MovieDAO movieDAO;
    private static ConcreteLocalSource concreteLocalSource = null;
    private LiveData<List<MovieModel>> storedMovies;

    public ConcreteLocalSource(Context context) {
        AppDataBase appDataBase = AppDataBase.getInstance(context.getApplicationContext());
        movieDAO = appDataBase.movieDAO();
        storedMovies = movieDAO.getAllMovies();
    }

    public static ConcreteLocalSource getInstance(Context context) {
        if (concreteLocalSource == null) {
            concreteLocalSource = new ConcreteLocalSource(context);
        }
        return concreteLocalSource;
    }

    @Override
    public void insertMovie(MovieModel movieModel) {
        new Thread(() -> {
            movieDAO.insertMovie(movieModel);
        }).start();
    }

    @Override
    public void deleteMovie(MovieModel movieModel) {
        new Thread(() -> {
            movieDAO.deleteMovie(movieModel);
        }).start();
        Log.d("TAG", "removeMovie: " + "movie deleted");
    }

    @Override
    public LiveData<List<MovieModel>> getAllStoredMovies() {
        return storedMovies;
    }
}
