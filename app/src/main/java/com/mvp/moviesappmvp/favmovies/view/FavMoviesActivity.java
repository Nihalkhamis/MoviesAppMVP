package com.mvp.moviesappmvp.favmovies.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.mvp.moviesappmvp.R;
import com.mvp.moviesappmvp.allmovies.presenter.AllMoviePresenter;
import com.mvp.moviesappmvp.db.ConcreteLocalSource;
import com.mvp.moviesappmvp.favmovies.presenter.FavoritePresenter;
import com.mvp.moviesappmvp.favmovies.presenter.favPresenterInterface;
import com.mvp.moviesappmvp.model.MovieModel;
import com.mvp.moviesappmvp.model.MovieRepository;
import com.mvp.moviesappmvp.network.MovieClient;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FavMoviesActivity extends AppCompatActivity implements onFavClickListener, favMovieViewInterface {

    RecyclerView allFavMovies_rv;
    ArrayList<MovieModel> movieModels;
    LinearLayoutManager linearLayoutManager;
    FavMoviesAdapter favMoviesAdapter;
   // MovieRepository movieRepository;

    favPresenterInterface favPresenterInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_movies);

        allFavMovies_rv = findViewById(R.id.allFavMovies_rv);
        allFavMovies_rv.setHasFixedSize(true);
        movieModels = new ArrayList<>();
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        allFavMovies_rv.setLayoutManager(linearLayoutManager);

        favMoviesAdapter = new FavMoviesAdapter(this, this);

        allFavMovies_rv.setAdapter(favMoviesAdapter);

        favPresenterInterface = new FavoritePresenter(this, MovieRepository.getInstance(MovieClient.getInstance(),
                ConcreteLocalSource.getInstance(this),this));

        favPresenterInterface.showAllStoredMovies(this);


//        movieRepository = MovieRepository.getInstance(this);
//        movieRepository.getStoredMovies().observe(this, new Observer<List<MovieModel>>() {
//            @Override
//            public void onChanged(List<MovieModel> movieModels) {
//                favMoviesAdapter.setData(movieModels);
//                favMoviesAdapter.notifyDataSetChanged();
//            }
//        });

    }

    @Override
    public void onCLick(MovieModel movieModel) {
     //handle the remove of movie
       // movieRepository.removeMovie(movieModel);
        deleteMovie(movieModel);
        favMoviesAdapter.notifyDataSetChanged();
        Toast.makeText(this, "Deleted from favorite", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void deleteMovie(MovieModel movieModel) {
        Log.d("TAG", "deleteMovie: " + "1");
        favPresenterInterface.deleteMovie(movieModel);
    }

    @Override
    public void getAllStoredMovies(List<MovieModel> movieModels) {
        Log.d("TAG", "setMovie: " + "0");
        favMoviesAdapter.setData(movieModels);
             // favMoviesAdapter.notifyDataSetChanged();
    }


}