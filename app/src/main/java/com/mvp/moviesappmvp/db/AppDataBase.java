package com.mvp.moviesappmvp.db;

import android.content.Context;

import com.mvp.moviesappmvp.model.MovieModel;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {MovieModel.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase appDataBase = null;
    public abstract MovieDAO movieDAO();
    public static synchronized AppDataBase getInstance(Context context){
        if (appDataBase == null){
            appDataBase = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class,"movies").build();
        }
        return appDataBase;
    }
}
