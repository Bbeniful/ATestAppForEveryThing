package com.example.atestappforeverything.feature_state_flow.presentation.ui.dashBoard

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DashBoardViewModel: ViewModel() {

    private var _testData = MutableStateFlow("data")
    var testData = _testData.asStateFlow()


    fun changeData(){
        _testData.value = "myTestData"
    }
}