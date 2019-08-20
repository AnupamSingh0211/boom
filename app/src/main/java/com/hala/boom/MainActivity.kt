package com.hala.boom

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Color
import android.media.MediaPlayer
import android.media.audiofx.Visualizer
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log


class MainActivity : AppCompatActivity() {

    lateinit var boomView: CircularView
    var countDownTimer: CountDownTimer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        boomView = CircularView(this)
        boomView.setBackgroundColor(Color.BLACK)
        setContentView(boomView)
        val MyVersion = Build.VERSION.SDK_INT
        if (MyVersion > Build.VERSION_CODES.LOLLIPOP_MR1) {
            if (!checkIfAlreadyhavePermission()) {
                requestForSpecificPermission()
            }else{
                playSong()
            }
        } else {
            playSong()
        }
    }

    fun playSong() {
        val resID = resources.getIdentifier("ukulele", "raw", this.packageName)

        val mediaPlayer = MediaPlayer.create(this, resID)
        mediaPlayer.start()

        createVisualizer(mediaPlayer)
    }


    private fun requestForSpecificPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.RECORD_AUDIO
            ),
            101
        )
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            101 -> if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //granted
                playSong()
            } else {
                //not granted
            }
            else -> super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }

    private fun checkIfAlreadyhavePermission(): Boolean {
        val result = ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)
        return if (result == PackageManager.PERMISSION_GRANTED) {
            true
        } else {
            false
        }
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


    private var audioOutput: Visualizer? = null
    var intensity = 0f

    override fun onPause() {
        super.onPause()
        try {
            countDownTimer?.cancel()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }


    private fun createVisualizer(mediaPlayer: MediaPlayer) {
        val rate = Visualizer.getMaxCaptureRate()
        audioOutput = Visualizer(mediaPlayer.audioSessionId) // get output audio stream
        audioOutput!!.setDataCaptureListener(object : Visualizer.OnDataCaptureListener {
            override fun onWaveFormDataCapture(visualizer: Visualizer, waveform: ByteArray, samplingRate: Int) {
                intensity = (waveform[0].toFloat() + 128f) / 256
                Log.d("vis", intensity.toString())
                boomView.invalidate()
            }

            override fun onFftDataCapture(visualizer: Visualizer, fft: ByteArray, samplingRate: Int) {

            }
        }, rate, true, false) // waveform not freq data
        Log.d("rate", Visualizer.getMaxCaptureRate().toString())
        audioOutput!!.setEnabled(true)
    }
}
