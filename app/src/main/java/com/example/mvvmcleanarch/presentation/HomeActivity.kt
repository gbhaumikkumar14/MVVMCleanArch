package com.example.mvvmcleanarch.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mvvmcleanarch.R
import com.example.mvvmcleanarch.databinding.ActivityHomeBinding
import com.example.mvvmcleanarch.presentation.artists.ArtistsActivity
import com.example.mvvmcleanarch.presentation.movies.MovieActivity
import com.example.mvvmcleanarch.presentation.tvShows.TvShowsActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        supportActionBar?.let {
            title = "The Movie Database"
        }

        binding.btnMovie.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        binding.btnTvShows.setOnClickListener {
            val intent = Intent(this, TvShowsActivity::class.java)
            startActivity(intent)
        }

        binding.btnArtists.setOnClickListener {
            val intent = Intent(this, ArtistsActivity::class.java)
            startActivity(intent)
        }
    }
}