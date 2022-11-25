package com.example.mvvmcleanarch.presentation.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
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
        (application as Injector).createMovieSubComponent().inject(this)
        movieViewModel = ViewModelProvider(this, moviesViewModelFactory)[MoviesViewModel::class.java]
        binding.rvMovies.layoutManager = LinearLayoutManager(
            this.applicationContext, LinearLayoutManager.VERTICAL, false)
        adapter = MoviesAdapter()
        binding.rvMovies.adapter = adapter

        getMovies()
    }

    private fun getMovies() {
        movieViewModel.getMovies().observe(this, Observer {
            it?.let {
                adapter.updateMovies(it)
                adapter.notifyDataSetChanged()
            }
        })
    }

    companion object{
        const val TAG = "MovieActivity"
    }
}