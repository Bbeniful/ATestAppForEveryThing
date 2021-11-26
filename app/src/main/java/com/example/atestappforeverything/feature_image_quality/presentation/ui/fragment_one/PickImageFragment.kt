package com.example.atestappforeverything.feature_image_quality.presentation.ui.fragment_one

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
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
import com.example.atestappforeverything.feature_image_quality.utils.FileHelpers
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import java.io.File
import java.io.FileInputStream

@AndroidEntryPoint
class PickImageFragment : Fragment() {

    private lateinit var binding: PickImageOneBinding
    private val viewModel: PickImageViewModel by viewModels()
    private lateinit var uri: Uri


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PickImageOneBinding.inflate(inflater, container, false)
        checkPermission(
            listOf(
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        )
        initUI()
        FileHelpers.listFiles(requireContext())
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
        FileHelpers.readImage(requireContext()).let {
            binding.pickImagePreview.setImageBitmap(it)
        }

        binding.pickImageBtn.setOnClickListener {
            //capturePhoto()
            openGallery()
        }
    }

    fun openGallery() {
        val i = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )
        startActivityForResult(i, REQUEST_PICK_GALLERY)
    }

    private fun checkPermission(permissions: List<String>) {
        for (perm in permissions) {
            ContextCompat.checkSelfPermission(requireContext(), perm).let {
                if (it == PackageManager.PERMISSION_DENIED) {
                    requestPermission()
                }
            }
        }
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            requireActivity(),
            arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE),
            REQUEST_IMAGE_CAPTURE
        )
    }

    companion object {
        const val REQUEST_IMAGE_CAPTURE = 1
        const val REQUEST_PICK_GALLERY = 2
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_IMAGE_CAPTURE -> {
                val bitmap = BitmapFactory.decodeStream(
                    requireActivity().contentResolver.openInputStream(uri)
                )
                binding.pickImagePreview.setImageBitmap(bitmap)
            }
            REQUEST_PICK_GALLERY -> {
                val imageUri = data?.data
                val file = File(FileHelpers.getPathFromUri(requireContext(), imageUri))
                file.copyTo(
                    File("${FileHelpers.getImagePath(requireContext())}/${FileHelpers.IMAGE_NAME}"),
                    true
                ).let {
                    val bitmap =
                        BitmapFactory.decodeStream(FileInputStream(file))
                    binding.pickImagePreview.setImageBitmap(bitmap)
                }
            }
        }
    }
}