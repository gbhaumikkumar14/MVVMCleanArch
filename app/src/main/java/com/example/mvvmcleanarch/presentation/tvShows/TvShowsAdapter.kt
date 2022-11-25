package com.example.mvvmcleanarch.presentation.tvShows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmcleanarch.R
import com.example.mvvmcleanarch.data.model.tvShow.TvShow
import com.example.mvvmcleanarch.databinding.MoviesItemViewholderBinding

class TvShowsAdapter: RecyclerView.Adapter<TvShowsViewHolder>() {
    private var moviesList = ArrayList<TvShow>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowsViewHolder {
        val layoutInflator = LayoutInflater.from(parent.context)
        val binding: MoviesItemViewholderBinding = DataBindingUtil.inflate(
            layoutInflator,
            R.layout.movies_item_viewholder,
            parent,
            false)
        return TvShowsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowsViewHolder, position: Int) {
        holder.bind(moviesList[position])
    }

    fun updateMovies(movies: List<TvShow>){
        moviesList.clear()
        moviesList = ArrayList(movies)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
}

class TvShowsViewHolder(private val binding: MoviesItemViewholderBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(tvShow: TvShow){
        binding.tvMovieTitle.text = tvShow.name
        binding.tvMovieDesc.text = tvShow.overview
        val posterUrl = "https://image.tmdb.org/t/p/w500/"+tvShow.posterPath
        Glide.with(binding.imageMoviePoster.context)
            .load(posterUrl)
            .into(binding.imageMoviePoster)
    }
}