package com.example.atestappforeverything.core.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.findNavController
import com.example.atestappforeverything.R
import com.example.atestappforeverything.databinding.ActivityMainBinding
import com.example.atestappforeverything.feature_data_store.presentation.ui.DataStoreActivity
import com.example.atestappforeverything.feature_state_flow.presentation.StateFlowActivity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStateFlow.setOnClickListener {
            startActivity(Intent(this, StateFlowActivity::class.java))
            finish()
        }
        binding.btnDataStore.setOnClickListener {
            startActivity(Intent(this, DataStoreActivity::class.java))
            finish()
        }


    }


}