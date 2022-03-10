package com.mvp.moviesappmvp.network;

import android.content.Context;

import com.mvp.moviesappmvp.model.MovieModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MovieClient implements remoteResource{
    private static final String base_URL = "https://api.androidhive.info/";
    private static Retrofit retrofit;
   // private ArrayList<MovieModel> movieModels = new ArrayList<>();
   // private Context context;
   // networkDelegate networkDelegate;
    public static MovieClient movieClient = null;

    public MovieClient() {
    }

    //    public MovieClient(Context context, networkDelegate networkDelegate) {
//        this.context = context;
//        this.networkDelegate = networkDelegate;
//    }

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(base_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;

    }

    public static MovieClient getInstance(){
        if (movieClient == null){
            movieClient = new MovieClient();
        }
        return movieClient;
    }

    @Override
    public void enqueueCall(networkDelegate networkDelegate) {
        movieService movieService = getClient().create(movieService.class);
        Call<ArrayList<MovieModel>> call = movieService.getAllMovies();
        call.enqueue(new Callback<ArrayList<MovieModel>>() {
            @Override
            public void onResponse(Call<ArrayList<MovieModel>> call, Response<ArrayList<MovieModel>> response) {
                if (response.isSuccessful()){
                    networkDelegate.onSuccessResult(response.body());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<MovieModel>> call, Throwable t) {
                networkDelegate.onFailureResult(t.getMessage());

            }
        });
    }
}
