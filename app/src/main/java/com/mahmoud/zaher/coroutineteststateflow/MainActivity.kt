package com.mahmoud.zaher.coroutineteststateflow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mahmoud.zaher.coroutineteststateflow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var timerViewModel: TimerViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        timerViewModel = ViewModelProvider(this).get(TimerViewModel::class.java)
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        timerViewModel.startTimer()
        timerViewModel.timerLiveData.observe(this, Observer {
            binding.timerTextView.text = it.toString()
        })
    }
}