package com.example.mvvmcleanarch.presentation.tvShows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmcleanarch.R
import com.example.mvvmcleanarch.databinding.ActivityTvShowsBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TvShowsActivity : AppCompatActivity() {
    @Inject
    lateinit var tvShowViewModelFactory: TvShowsViewModelFactory
    private lateinit var tvShowViewModel: TvShowsViewModel
    private lateinit var adapter: TvShowsAdapter
    private lateinit var binding : ActivityTvShowsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_shows)

        supportActionBar?.let {
            title = "TvShows"
            it.subtitle = "Popular tv shows"
        }

        tvShowViewModel = ViewModelProvider(this, tvShowViewModelFactory)[TvShowsViewModel::class.java]
        binding.rvTvShows.layoutManager = LinearLayoutManager(
            this.applicationContext, LinearLayoutManager.VERTICAL, false)
        adapter = TvShowsAdapter()
        binding.rvTvShows.adapter = adapter

        binding.tvShowsRefresh.setOnRefreshListener {
            tvShowViewModel.updateTvShows().observe(this) {
                binding.tvShowsRefresh.isRefreshing = false
                it?.let {
                    adapter.updateMovies(it)
                    adapter.notifyDataSetChanged()
                }
            }
        }

        getMovies()
    }

    private fun getMovies() {
        binding.tvShowsRefresh.isRefreshing = true
        tvShowViewModel.getTvShows().observe(this) {
            binding.tvShowsRefresh.isRefreshing = false
            it?.let {
                adapter.updateMovies(it)
                adapter.notifyDataSetChanged()
            }
        }
    }
}