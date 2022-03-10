package com.mvp.moviesappmvp.model;

import android.content.Context;
import android.util.Log;

import com.mvp.moviesappmvp.db.localSource;
import com.mvp.moviesappmvp.network.networkDelegate;
import com.mvp.moviesappmvp.network.remoteResource;
import com.mvp.moviesappmvp.db.AppDataBase;
import com.mvp.moviesappmvp.db.MovieDAO;

import java.util.List;

import androidx.lifecycle.LiveData;

public class MovieRepository implements movieRepositoryInterface {

    private Context context;
    //private MovieDAO movieDAO;
   // LiveData<List<MovieModel>> storedMovies;

    remoteResource remoteResource;
    localSource localSource;

    private static MovieRepository movieRepository = null;

    /*public MovieRepository(Context context) {
        this.context = context;
        AppDataBase db = AppDataBase.getInstance(context.getApplicationContext());
        movieDAO = db.movieDAO();
        storedMovies = movieDAO.getAllMovies();

    }*/

    public MovieRepository(remoteResource remoteResource, localSource localSource, Context context) {
        this.context = context;
        this.remoteResource = remoteResource;
        this.localSource = localSource;
    }

    public static MovieRepository getInstance(remoteResource remoteResource, localSource localSource ,Context context){
        if (movieRepository == null){
            movieRepository = new MovieRepository(remoteResource,localSource,context);
        }
        return movieRepository;
    }

    @Override
    public LiveData<List<MovieModel>> getStoredMovies() {
        return localSource.getAllStoredMovies();
    }

    @Override
    public void getAllMovies(networkDelegate networkDelegate) {
        remoteResource.enqueueCall(networkDelegate);
    }

    @Override
    public void insertMovie(MovieModel movieModel) {
        localSource.insertMovie(movieModel);
    }

    @Override
    public void deleteMovie(MovieModel movieModel) {
    localSource.deleteMovie(movieModel);
    }

   /* public LiveData<List<MovieModel>> getStoredMovies(){
        return storedMovies;
    }



    public void insertMovie(MovieModel movieModel){
        new Thread(() -> {
           movieDAO.insertMovie(movieModel);
        }).start();
    }

    public void removeMovie(MovieModel movieModel){
        new Thread(() -> {
            movieDAO.deleteMovie(movieModel);
        }).start();
        Log.d("TAG", "removeMovie: "+ "movie deleted");
    }*/
}
