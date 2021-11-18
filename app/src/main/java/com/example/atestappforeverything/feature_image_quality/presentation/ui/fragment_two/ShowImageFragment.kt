package com.example.atestappforeverything.feature_image_quality.presentation.ui.fragment_two

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.atestappforeverything.databinding.PickImageTwoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowImageFragment : Fragment() {
    private lateinit var binding: PickImageTwoBinding
    private val viewModel: ShowImageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PickImageTwoBinding.inflate(inflater, container, false)


        return binding.root
    }
}