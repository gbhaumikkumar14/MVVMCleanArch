package com.example.mvvmcleanarch.presentation.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmcleanarch.R
import com.example.mvvmcleanarch.data.model.movie.Movie
import com.example.mvvmcleanarch.databinding.MoviesItemViewholderBinding

class MoviesAdapter: RecyclerView.Adapter<MoviesViewHolder>() {
    private var moviesList = ArrayList<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val layoutInflator = LayoutInflater.from(parent.context)
        val binding: MoviesItemViewholderBinding = DataBindingUtil.inflate(
            layoutInflator,
            R.layout.movies_item_viewholder,
            parent,
            false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(moviesList[position])
    }

    fun updateMovies(movies: List<Movie>){
        moviesList.clear()
        moviesList = ArrayList(movies)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
}

class MoviesViewHolder(private val binding: MoviesItemViewholderBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(movie: Movie){
        binding.tvMovieTitle.text = movie.title
        binding.tvMovieDesc.text = movie.overview
        val posterUrl = "https://image.tmdb.org/t/p/w500/"+movie.posterPath
        Glide.with(binding.imageMoviePoster.context)
            .load(posterUrl)
            .into(binding.imageMoviePoster)
    }
}