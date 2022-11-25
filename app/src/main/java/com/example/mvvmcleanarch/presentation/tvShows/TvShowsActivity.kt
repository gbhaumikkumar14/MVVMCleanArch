package com.example.mvvmcleanarch.presentation.tvShows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmcleanarch.R
import com.example.mvvmcleanarch.databinding.ActivityTvShowsBinding
import com.example.mvvmcleanarch.presentation.di.Injector
import javax.inject.Inject

class TvShowsActivity : AppCompatActivity() {
    @Inject
    lateinit var tvShowViewModelFactory: TvShowsViewModelFactory
    private lateinit var tvShowViewModel: TvShowsViewModel
    private lateinit var adapter: TvShowsAdapter
    private lateinit var binding : ActivityTvShowsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_shows)
        (application as Injector).createTvShowSubComponent().inject(this)
        tvShowViewModel = ViewModelProvider(this, tvShowViewModelFactory)[TvShowsViewModel::class.java]
        binding.rvTvShows.layoutManager = LinearLayoutManager(
            this.applicationContext, LinearLayoutManager.VERTICAL, false)
        adapter = TvShowsAdapter()
        binding.rvTvShows.adapter = adapter

        getMovies()
    }

    private fun getMovies() {
        tvShowViewModel.getTvShows().observe(this, Observer {
            it?.let {
                adapter.updateMovies(it)
                adapter.notifyDataSetChanged()
            }
        })
    }
}