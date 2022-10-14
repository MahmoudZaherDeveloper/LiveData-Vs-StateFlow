package com.mahmoud.zaher.coroutineteststateflow

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TimerViewModel : ViewModel() {
    private val _timerLiveData = MutableLiveData<Int>()
    val timerLiveData: MutableLiveData<Int> = _timerLiveData

    fun startTimer() {
        viewModelScope.launch {
            val list = listOf(1, 1, 1, 2, 2, 3, 3, 3, 4, 5, 5, 6, 6, 7)
            // for (i in 1..10) {
            for (i in list) {
                _timerLiveData.value = i
                delay(1000)
                Log.d("TAG", "startTimer: $i ")
            }
        }
    }
}