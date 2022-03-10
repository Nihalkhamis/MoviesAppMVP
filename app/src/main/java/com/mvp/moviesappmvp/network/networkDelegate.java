package com.mvp.moviesappmvp.network;

import com.mvp.moviesappmvp.model.MovieModel;

import java.util.ArrayList;

public interface networkDelegate {
     void onSuccessResult(ArrayList<MovieModel> movieModels);
     void onFailureResult(String errorMsg);
}
