package com.hala.boom

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var boomView: BoomView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        boomView = BoomView(this)
        boomView.setBackgroundColor(Color.WHITE)
        setContentView(boomView)
    }
}
