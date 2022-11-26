package com.example.mvvmcleanarch.presentation.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmcleanarch.R
import com.example.mvvmcleanarch.databinding.ActivityMovieBinding
import com.example.mvvmcleanarch.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var moviesViewModelFactory: MoviesViewModelFactory
    private lateinit var movieViewModel: MoviesViewModel
    private lateinit var binding: ActivityMovieBinding
    private lateinit var adapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)

        supportActionBar?.let {
            title = "Movies"
            it.subtitle = "Popular movies"
        }

        (application as Injector).createMovieSubComponent().inject(this)
        movieViewModel = ViewModelProvider(this, moviesViewModelFactory)[MoviesViewModel::class.java]
        binding.rvMovies.layoutManager = LinearLayoutManager(
            this.applicationContext, LinearLayoutManager.VERTICAL, false)
        adapter = MoviesAdapter()
        binding.rvMovies.adapter = adapter

        binding.movieRefresh.setOnRefreshListener {
            movieViewModel.updateMovies().observe(this) {
                binding.movieRefresh.isRefreshing = false
                it?.let {
                    adapter.updateMovies(it)
                    adapter.notifyDataSetChanged()
                }
            }
        }

        getMovies()
    }

    private fun getMovies() {
        binding.movieRefresh.isRefreshing = true
        movieViewModel.getMovies().observe(this) {
            binding.movieRefresh.isRefreshing = false
            it?.let {
                adapter.updateMovies(it)
                adapter.notifyDataSetChanged()
            }
        }
    }
}