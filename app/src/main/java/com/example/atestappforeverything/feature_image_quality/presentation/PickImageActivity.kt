package com.example.atestappforeverything.feature_image_quality.presentation

import android.os.Binder
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.atestappforeverything.databinding.ActivityPickImageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PickImageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPickImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPickImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}