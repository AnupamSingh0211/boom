package com.hala.boom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Color.BLACK
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Shader.TileMode
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View


/**
 * @author Anupam Singh
 * @version 1.0
 * @since 2019-07-24
 */

class LinearBoomView : View {


    var paint = Paint()
    var blockHeight: Float = 0.0f
    var startingHeight = 0.0f
    var colorArray: IntArray
    var currentColor: Int
    var intensityVal: Float = 0.0f

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        // getXmlAttrs(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        //  getXmlAttrs(context, attrs)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleValues: Int) :
            super(context, attrs, defStyleAttr, defStyleValues) {
        // getXmlAttrs(context, attrs)
    }


    init {
        blockHeight = (CodeUtils.getHeightPixels(context)).toFloat()
        colorArray = intArrayOf(Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.MAGENTA, Color.YELLOW)
        currentColor = colorArray[0]
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

//        mPaint.setColor(Color.RED);
//        mPaint.setStrokeWidth(3.0f);
//        canvas?.drawRect(0.0f, 0.0f, CodeUtils.getWidthPixels(context).toFloat(), blockHeight, mPaint);


        if (startingHeight >= blockHeight) {
            startingHeight = 0.0f
            // currentColor = colorArray[Random.nextInt(0, 5)]
            val red: Int = ((255 * intensityVal).toInt())
            val green: Int = (130 * intensityVal).toInt()
            val blue: Int = (100 / intensityVal).toInt()

            currentColor = Color.argb(125, red, green, blue)

        } else
            startingHeight = startingHeight + (40).toInt()


        val shader = LinearGradient(0f, startingHeight - 200, startingHeight, blockHeight, BLACK, currentColor, TileMode.CLAMP)
        val paintRed = Paint()
        paintRed.shader = shader
        canvas?.drawRect(0.0f, 0.0f, CodeUtils.getWidthPixels(context).toFloat(), blockHeight, paintRed);


//        mPaint.setColor(Color.GREEN);
//        mPaint.setStrokeWidth(3.0f);
//        canvas?.drawRect(0.0f, 2 * blockHeight, CodeUtils.getWidthPixels(context).toFloat(), blockHeight, mPaint)
//
//
//        mPaint.setColor(Color.BLUE);
//        mPaint.setStrokeWidth(3.0f);
//        canvas?.drawRect(0.0f, 3 * blockHeight, CodeUtils.getWidthPixels(context).toFloat(), 2 * blockHeight, mPaint);


    }

    fun setIntensity(intensity: Float) {
        intensityVal = intensity
        invalidate()
    }

}