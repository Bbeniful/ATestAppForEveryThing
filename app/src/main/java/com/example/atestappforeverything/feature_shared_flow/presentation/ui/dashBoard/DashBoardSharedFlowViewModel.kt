package com.example.atestappforeverything.feature_shared_flow.presentation.ui.dashBoard

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DashBoardSharedFlowViewModel: ViewModel() {

    private var _testData = MutableStateFlow("data")
    var testData = _testData.asStateFlow()


    fun changeData(){
        _testData.value = "myTestData"
    }
}