package com.example.atestappforeverything.feature_state_flow.domain.use_cases

import java.util.*
import java.util.logging.Handler

class RunMethodXSecondUseCase {

    operator fun invoke(ms: Long, method: () -> Unit) {
        Timer().scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                method
            }
        }, 0, ms) //put here time 1000 milliseconds=1 second

    }
}