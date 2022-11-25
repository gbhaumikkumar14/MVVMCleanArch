package com.example.mvvmcleanarch.presentation.artists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmcleanarch.R
import com.example.mvvmcleanarch.databinding.ActivityArtistsBinding
import com.example.mvvmcleanarch.presentation.di.Injector
import javax.inject.Inject

class ArtistsActivity : AppCompatActivity() {
    @Inject
    lateinit var artistViewModelFactory: ArtistsViewModelFactory
    private lateinit var artistViewModel: ArtistsViewModel
    private lateinit var adapter: ArtistsAdapter
    private lateinit var binding: ActivityArtistsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artists)
        (application as Injector).createArtistSubComponent().inject(this)
        artistViewModel = ViewModelProvider(this, artistViewModelFactory)[ArtistsViewModel::class.java]
        binding.rvArtists.layoutManager = LinearLayoutManager(
            this.applicationContext, LinearLayoutManager.VERTICAL, false)
        adapter = ArtistsAdapter()
        binding.rvArtists.adapter = adapter

        getMovies()
    }

    private fun getMovies() {
        artistViewModel.getArtists().observe(this, Observer {
            it?.let {
                adapter.updateMovies(it)
                adapter.notifyDataSetChanged()
            }
        })
    }
}