package com.example.atestappforeverything.feature_image_quality.presentation.ui.fragment_one

import androidx.lifecycle.ViewModel
import com.example.atestappforeverything.feature_image_quality.data.service.FileHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.File
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class PickImageViewModel @Inject constructor(
    private val fileHandle: FileHandle
) : ViewModel() {


    @Throws(IOException::class)
    fun createImageFile(fileName: String): File? {
        return try {
            val file = File(fileHandle.PATH, "$fileName.jpg")
            if (file.createNewFile() || file.exists()) {
                file
            } else {
                null
            }
        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

}