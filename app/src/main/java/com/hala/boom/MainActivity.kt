package com.hala.boom

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var boomView: MultiColorLinearBoomView
    var countDownTimer: CountDownTimer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        boomView = MultiColorLinearBoomView(this)
        boomView.setBackgroundColor(Color.WHITE)
        setContentView(boomView)
        usingCountDownTimer()

    }

    fun usingCountDownTimer() {
        countDownTimer = object : CountDownTimer(java.lang.Long.MAX_VALUE, 35) {

            // This is called after every 10 sec interval.
            override fun onTick(millisUntilFinished: Long) {
                boomView.invalidate()
            }

            override fun onFinish() {
                start()
            }
        }.start()
    }

    override fun onPause() {
        super.onPause()
        try {
            countDownTimer?.cancel()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}
