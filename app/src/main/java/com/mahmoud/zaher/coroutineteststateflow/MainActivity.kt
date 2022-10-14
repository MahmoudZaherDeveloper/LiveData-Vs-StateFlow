package com.mahmoud.zaher.coroutineteststateflow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.mahmoud.zaher.coroutineteststateflow.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var timerViewModel: TimerViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        timerViewModel = ViewModelProvider(this).get(TimerViewModel::class.java)
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        timerViewModel.startTimer()

        lifecycleScope.launch {
            timerViewModel.stateFlowTimer.collect {
                binding.timerTextView.text = it.toString()
            }
        }
    }
}