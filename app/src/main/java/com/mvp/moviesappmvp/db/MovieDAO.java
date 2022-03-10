package com.mvp.moviesappmvp.db;

import com.mvp.moviesappmvp.model.MovieModel;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface MovieDAO {
    @Query("SELECT * from movies")
    LiveData<List<MovieModel>> getAllMovies();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMovie(MovieModel movieModel);

    @Delete
    void deleteMovie(MovieModel movieModel);
}
