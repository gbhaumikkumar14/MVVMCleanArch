package com.example.mvvmcleanarch.presentation.artists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmcleanarch.R
import com.example.mvvmcleanarch.data.model.artist.Artist
import com.example.mvvmcleanarch.databinding.MoviesItemViewholderBinding

class ArtistsAdapter: RecyclerView.Adapter<ArtistViewHolder>() {
    private var moviesList = ArrayList<Artist>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val layoutInflator = LayoutInflater.from(parent.context)
        val binding: MoviesItemViewholderBinding = DataBindingUtil.inflate(
            layoutInflator,
            R.layout.movies_item_viewholder,
            parent,
            false)
        return ArtistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(moviesList[position])
    }

    fun updateMovies(movies: List<Artist>){
        moviesList.clear()
        moviesList = ArrayList(movies)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
}

class ArtistViewHolder(private val binding: MoviesItemViewholderBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(artist: Artist){
        binding.tvMovieTitle.text = artist.name
        binding.tvMovieDesc.text = artist.popularity.toString()
        val posterUrl = "https://image.tmdb.org/t/p/w500/"+artist.profilePath
        Glide.with(binding.imageMoviePoster.context)
            .load(posterUrl)
            .into(binding.imageMoviePoster)
    }
}