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
import com.example.atestappforeverything.feature_shared_flow.presentation.SharedFlowActivity
import com.example.atestappforeverything.feature_state_flow.presentation.StateFlowActivity
import com.example.atestappforeverything.feature_wifi_provisioning.presentation.ui.provisioning.ProvisioningActivity
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
        }

        binding.btnShredFlow.setOnClickListener {
            startActivity(Intent(this, SharedFlowActivity::class.java))
        }

        binding.btnDataStore.setOnClickListener {
            startActivity(Intent(this, DataStoreActivity::class.java))
        }

        binding.btnWifiProvisioning.setOnClickListener {
            startActivity(Intent(this, ProvisioningActivity::class.java))
        }

    }


}