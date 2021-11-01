package com.example.atestappforeverything.feature_shared_flow.utils

import com.example.atestappforeverything.feature_state_flow.domain.models.Apple
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

object TestSharedFlowObject {

    private val _sharedFlow = MutableSharedFlow<Apple>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    suspend fun setValueForSharedFlow(
        name: String,
        size: Int,
        type: ArrayList<Int> = arrayListOf()
    ) {
        _sharedFlow.emit(
            Apple(
                name = name,
                size = size,
                type = type
            )
        )
    }
}