package com.mvp.moviesappmvp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.mvp.moviesappmvp.allmovies.view.AllMoviesActivity;
import com.mvp.moviesappmvp.favmovies.view.FavMoviesActivity;


public class MainActivity extends AppCompatActivity {
    Button getAllMovies_btn;
    Button getFavMovies_btn;
    Button exit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getAllMovies_btn = findViewById(R.id.getAllMovies_btn);
        getFavMovies_btn = findViewById(R.id.getFavMovies_btn);
        exit_btn = findViewById(R.id.exit_btn);

        getAllMovies_btn.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, AllMoviesActivity.class));
        });

        getFavMovies_btn.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, FavMoviesActivity.class));
        });

        exit_btn.setOnClickListener(view -> {
            finish();
        });
    }
}