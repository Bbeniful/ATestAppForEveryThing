package com.example.atestappforeverything.feature_image_quality.presentation.ui.fragment_one

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.atestappforeverything.BuildConfig
import com.example.atestappforeverything.databinding.PickImageOneBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import java.io.File

@AndroidEntryPoint
class PickImageFragment : Fragment() {

    private lateinit var binding: PickImageOneBinding
    private val viewModel: PickImageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PickImageOneBinding.inflate(inflater, container, false)
        checkPermission()
        initUI()
        return binding.root
    }


    private val registerTakePicture = registerForActivityResult(
        ActivityResultContracts.TakePicture()
    ) { isSuccess ->
        if (isSuccess) {
            Snackbar.make(binding.root, "$isSuccess", Snackbar.LENGTH_SHORT).show()
        } else {
            Snackbar.make(binding.root, "$isSuccess", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun initUI() {
        binding.pickImageBtn.setOnClickListener {
            takeImage()
        }
    }


    private fun takeImage() {
        val photoFile: File? = viewModel.createImageFile("testFileName")
        photoFile?.also {
            val photoURI: Uri = FileProvider.getUriForFile(
                requireContext(),
                BuildConfig.APPLICATION_ID + ".fileProvider",
                it
            )
            registerTakePicture.launch(photoURI)
        }
    }


    private fun checkPermission() {
        ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA).let {
            if (it == PackageManager.PERMISSION_DENIED) {
                requestPermission()
            }
        }
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            requireActivity(),
            arrayOf(Manifest.permission.CAMERA),
            REQUEST_IMAGE_CAPTURE
        )
    }

    companion object {
        const val REQUEST_IMAGE_CAPTURE = 1
    }
}