package com.example.atestappforeverything.feature_image_quality.presentation.ui.fragment_two

import androidx.lifecycle.ViewModel
import com.example.atestappforeverything.feature_image_quality.data.service.FileHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShowImageViewModel @Inject constructor(
    private val fileHandle: FileHandle
) : ViewModel() {

}