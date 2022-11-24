package com.example.mvvmcleanarch.presentation.artists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mvvmcleanarch.R
import com.example.mvvmcleanarch.databinding.ActivityArtistsBinding

class ArtistsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArtistsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artists)
    }
}