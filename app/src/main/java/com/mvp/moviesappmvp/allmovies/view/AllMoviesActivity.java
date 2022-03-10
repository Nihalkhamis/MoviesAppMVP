package com.mvp.moviesappmvp.allmovies.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.mvp.moviesappmvp.R;
import com.mvp.moviesappmvp.allmovies.presenter.AllMoviePresenter;
import com.mvp.moviesappmvp.allmovies.presenter.allMoviePresenterInterface;
import com.mvp.moviesappmvp.db.ConcreteLocalSource;
import com.mvp.moviesappmvp.model.MovieModel;
import com.mvp.moviesappmvp.model.MovieRepository;
import com.mvp.moviesappmvp.network.MovieClient;
import com.mvp.moviesappmvp.network.networkDelegate;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AllMoviesActivity extends AppCompatActivity implements onMovieClickListener, allMovieViewInterface {

    //ArrayList<MovieModel> movieModels;

    RecyclerView allMovies_rv;
    LinearLayoutManager linearLayoutManager;
    AllMoviesAdapter allMoviesAdapter;
   // MovieClient movieClient;

    allMoviePresenterInterface allMoviePresenterInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_movies);

        allMovies_rv = findViewById(R.id.allMovies_rv);
        allMovies_rv.setHasFixedSize(true);
        //movieModels = new ArrayList<>();
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        allMovies_rv.setLayoutManager(linearLayoutManager);

        allMoviesAdapter = new AllMoviesAdapter(this, this);

        //initialization of presenter here is missing
        allMoviePresenterInterface = new AllMoviePresenter(this, MovieRepository.getInstance(MovieClient.getInstance(),
                ConcreteLocalSource.getInstance(this),this));

        allMovies_rv.setAdapter(allMoviesAdapter);

        allMoviePresenterInterface.getMovies();

//        movieClient = MovieClient.getInstance(getApplicationContext(),this);
//
//        movieClient.enqueueCall();

//       movieService movieService = MovieClient.getClient().create(movieService.class);   //create object from class that implements movieService
//        Call<ArrayList<MovieModel>> call = movieService.getAllMovies();
//        call.enqueue(new Callback<ArrayList<MovieModel>>() {
//            @Override
//            public void onResponse(Call<ArrayList<MovieModel>> call, Response<ArrayList<MovieModel>> response) {
//                if (response.isSuccessful()){
//                    movieModels = response.body();
//                    Log.d("TAG", "onResponse: " + movieModels);
//                    allMoviesAdapter.setData(movieModels);
//                    allMoviesAdapter.notifyDataSetChanged();
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<MovieModel>> call, Throwable t) {
//                Log.d("TAG", "onFailure: " + t.getMessage());
//            }
//        });


    }

    @Override
    public void onCLick(MovieModel movieModel) {
        addMovie(movieModel);
//        MovieRepository movieRepository = MovieRepository.getInstance(this);
//        movieRepository.insertMovie(movieModel);
        Toast.makeText(this, "Added to favorite", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showData(ArrayList<MovieModel> movieModels) {
        allMoviesAdapter.setData(movieModels);
        allMoviesAdapter.notifyDataSetChanged();
    }

    @Override
    public void addMovie(MovieModel movieModel) {
       //presenter.addToFav() implementation missing
        allMoviePresenterInterface.addToFav(movieModel);
    }

   /* @Override
    public void onSuccessResult(ArrayList<MovieModel> movieModels) {
        allMoviesAdapter.setData(movieModels);
        allMoviesAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailureResult(String errorMsg) {
        Log.d("TAG", "onFailureResult: " + errorMsg);
    }*/
}