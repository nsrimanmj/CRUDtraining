package com.example.crudtraining

import android.os.CountDownTimer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class SignUpViewModel:ViewModel() {


    var firstName by mutableStateOf("")
    var lastName by mutableStateOf("")
    var email by mutableStateOf("")
    var verificationCode by mutableStateOf("")
    private var countDownTimer: CountDownTimer? = null

    var timerText by mutableStateOf("")
        private set

    var isPlaying by mutableStateOf(true)
        private set

    fun startCountDownTimer(){
        viewModelScope.launch {
            isPlaying = true
            countDownTimer = object : CountDownTimer(20000L,1){
                override fun onTick(millisUntilFinished: Long) {
                    timerText = "Didn't receive the code? Retry in ${millisecondsToTimeString(millisUntilFinished)}"
                }

                override fun onFinish() {
                    isPlaying = false
                    countDownTimer?.cancel()
                }
            }.start()
        }
    }

    fun stopCountDownTimer(){
        isPlaying = false
        countDownTimer?.cancel()
    }

    fun millisecondsToTimeString(millis: Long): String {
        val duration = millis.milliseconds
        val components = duration.toComponents { hours, minutes, seconds, _ ->
            Triple(hours, minutes, seconds)
        }
        return String.format("%02d:%02d", components.second, components.third)
    }
}