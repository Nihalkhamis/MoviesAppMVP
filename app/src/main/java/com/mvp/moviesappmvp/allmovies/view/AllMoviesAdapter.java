package com.mvp.moviesappmvp.allmovies.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mvp.moviesappmvp.R;
import com.mvp.moviesappmvp.model.MovieModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AllMoviesAdapter extends RecyclerView.Adapter<AllMoviesAdapter.ViewHolder> {
    private Context context;
    private ArrayList<MovieModel> movieModels = new ArrayList<>();
    private onMovieClickListener onMovieClickListener;

    public AllMoviesAdapter(Context context, onMovieClickListener onMovieClickListener) {
        this.context = context;
        this.onMovieClickListener = onMovieClickListener;
    }

    public void setData(ArrayList<MovieModel> movieModels) {
        this.movieModels.addAll(movieModels);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_movie, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title_result_tv.setText(movieModels.get(position).getTitle());
        holder.release_result_tv.setText(movieModels.get(position).getReleaseYear());
        holder.ratingBar.setRating(movieModels.get(position).getRating());
        Glide.with(context).load(movieModels.get(position).getImage())
                .apply(new RequestOptions().override(200,200))
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.imageView);
        holder.addToFav_btn.setOnClickListener(view -> {
             onMovieClickListener.onCLick(movieModels.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return movieModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title_result_tv;
        TextView release_result_tv;
        RatingBar ratingBar;
        Button addToFav_btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            title_result_tv = itemView.findViewById(R.id.title_result_tv);
            release_result_tv = itemView.findViewById(R.id.release_result_tv);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            addToFav_btn = itemView.findViewById(R.id.addToFav_btn);

        }
    }
}
