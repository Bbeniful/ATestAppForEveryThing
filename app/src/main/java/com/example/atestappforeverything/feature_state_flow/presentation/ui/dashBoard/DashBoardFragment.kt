package com.example.atestappforeverything.feature_state_flow.presentation.ui.dashBoard

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.atestappforeverything.R
import com.example.atestappforeverything.databinding.DashBoardViewBinding
import com.example.atestappforeverything.feature_state_flow.domain.models.Apple
import com.example.atestappforeverything.feature_state_flow.utils.TestFlowObj

class DashBoardFragment : Fragment() {

    private lateinit var binding: DashBoardViewBinding
    private val viewModel: DashBoardViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DashBoardViewBinding.inflate(inflater, container, false)

        Handler(Looper.getMainLooper()).postDelayed({
            TestFlowObj.changeData(
                name = "Apple State flow",
                size = 15,
                type = arrayListOf(1,2)
            )
        }, 10000)

        Handler(Looper.getMainLooper()).postDelayed({
            TestFlowObj.changeData(
                name = "Apple State flow 2",
                size = 15,
                type = arrayListOf(1,2)

            )
        }, 20000)

        Handler(Looper.getMainLooper()).postDelayed({
            TestFlowObj.changeData(
                name = "Apple  State flow",
                size = 20,
                type = arrayListOf(4,5)
            )
        }, 25000)


        binding.dashButton.setOnClickListener {
            findNavController().navigate(R.id.nav_data)
        }
        return binding.root
    }
}