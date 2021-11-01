package com.example.atestappforeverything.feature_shared_flow.presentation.ui.data

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.atestappforeverything.databinding.DataViewBinding
import com.example.atestappforeverything.feature_state_flow.utils.TestFlowObj
import kotlinx.coroutines.flow.collectLatest

class DataSharedFlowFragment : Fragment() {
    private lateinit var binding: DataViewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataViewBinding.inflate(inflater, container, false)
        lifecycleScope.launchWhenStarted {
            TestFlowObj.testData.collectLatest {
                binding.tv.text = "Name : ${it.name} size: ${it.size} type: ${it.type}"
            }
        }

        return binding.root
    }


}