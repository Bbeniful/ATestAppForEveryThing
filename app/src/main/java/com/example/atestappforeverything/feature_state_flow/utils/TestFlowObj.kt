package com.example.atestappforeverything.feature_state_flow.utils

import com.example.atestappforeverything.feature_state_flow.domain.models.Apple
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object TestFlowObj {


    private val _testData = MutableStateFlow(Apple())
    val testData = _testData.asStateFlow()


    fun changeData(name: String, size: Int, type: ArrayList<Int> = arrayListOf(1, 2)) {
        _testData.value = Apple(
            name = name,
            size = size,
            type = type
        )
    }
}