package com.example.atestappforeverything.feature_state_flow.presentation

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.findNavController
import com.example.atestappforeverything.R
import com.example.atestappforeverything.databinding.StateFlowActivityViewBinding

class StateFlowActivity : AppCompatActivity() {
    private lateinit var binding: StateFlowActivityViewBinding
    private var navController: NavController? = null
    private var graph: NavGraph? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = StateFlowActivityViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
/*

        navController = findNavController(R.id.fragmentContainerView)
        graph = navController?.graph
*/

    }
}