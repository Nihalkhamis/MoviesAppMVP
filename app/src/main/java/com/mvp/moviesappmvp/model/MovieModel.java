package com.mvp.moviesappmvp.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "movies")
public class MovieModel {
    @PrimaryKey
    @ColumnInfo(name = "Title")
    @NonNull
    private String title;
    @ColumnInfo(name = "Release Year")
    private String releaseYear;
    @ColumnInfo(name = "Image")
    private String image;
    @ColumnInfo(name = "Rating")
    private float rating;

    public MovieModel(String title, String image, float rating, String releaseYear) {
        this.title = title;
        this.image = image;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public String getImage() {
        return image;
    }

    public float getRating() {
        return rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setImage(String poster) {
        this.image = poster;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
