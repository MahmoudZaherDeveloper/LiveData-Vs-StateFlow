package com.mahmoud.zaher.coroutineteststateflow

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class TimerViewModel : ViewModel() {
    private val _stateFlowTimer = MutableStateFlow<Int>(0)
    val stateFlowTimer: MutableStateFlow<Int> = _stateFlowTimer

    fun startTimer() {
        viewModelScope.launch {
            val list = listOf(1, 1, 2, 2, 3, 3, 3, 4, 5, 5, 6, 6, 7)
            for (i in list) {
                //for (i in 1..10) {
                _stateFlowTimer.emit(i)
                delay(1000)
                Log.d("TAG", "startTimer: $i")
            }
        }
    }
}