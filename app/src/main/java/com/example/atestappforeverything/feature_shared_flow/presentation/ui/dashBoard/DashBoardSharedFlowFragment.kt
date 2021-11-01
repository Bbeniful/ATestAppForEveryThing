package com.example.atestappforeverything.feature_shared_flow.presentation.ui.dashBoard

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.atestappforeverything.R
import com.example.atestappforeverything.databinding.DashBoardViewBinding
import com.example.atestappforeverything.feature_shared_flow.utils.TestSharedFlowObject
import com.example.atestappforeverything.feature_state_flow.utils.TestFlowObj
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DashBoardSharedFlowFragment : Fragment() {

    private lateinit var binding: DashBoardViewBinding
    private val viewModel: DashBoardSharedFlowViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DashBoardViewBinding.inflate(inflater, container, false)

        Handler(Looper.getMainLooper()).postDelayed({
            lifecycleScope.launch {
                TestSharedFlowObject.setValueForSharedFlow(
                    name = "Apple shared flow",
                    size = 1,
                    type = arrayListOf(1, 2)
                )
            }


        }, 10000)

        Handler(Looper.getMainLooper()).postDelayed({
            lifecycleScope.launch {
                TestSharedFlowObject.setValueForSharedFlow(
                    name = "Apple shared flow 2",
                    size = 2,
                    type = arrayListOf(1, 2)
                )
            }

        }, 20000)

        Handler(Looper.getMainLooper()).postDelayed({
            lifecycleScope.launch {
                TestSharedFlowObject.setValueForSharedFlow(
                    name = "Apple shared flow",
                    size = 1,
                    type = arrayListOf(4, 5)
                )
            }

        }, 25000)

        Handler(Looper.getMainLooper()).postDelayed({
            activity?.finish()

        }, 30000)





        binding.dashButton.setOnClickListener {
            findNavController().navigate(R.id.nav_data_shared_flow)
        }
        return binding.root
    }
}