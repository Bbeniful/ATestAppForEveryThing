package com.example.atestappforeverything.feature_shared_flow.presentation

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.findNavController
import com.example.atestappforeverything.R
import com.example.atestappforeverything.databinding.SharedFlowActivityViewBinding
import com.example.atestappforeverything.databinding.StateFlowActivityViewBinding

class SharedFlowActivity : AppCompatActivity() {
    private lateinit var binding: SharedFlowActivityViewBinding
    private var navController: NavController? = null
    private var graph: NavGraph? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SharedFlowActivityViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}