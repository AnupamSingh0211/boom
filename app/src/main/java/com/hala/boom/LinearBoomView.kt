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
import kotlin.random.Random


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

//        paint.setColor(Color.RED);
//        paint.setStrokeWidth(3.0f);
//        canvas?.drawRect(0.0f, 0.0f, CodeUtils.getWidthPixels(context).toFloat(), blockHeight, paint);


        if (startingHeight >= blockHeight) {
            startingHeight = 0.0f
            currentColor = colorArray[Random.nextInt(0, 5)]

        } else
            startingHeight = startingHeight + 40.0f


        val shader = LinearGradient(0f, startingHeight-200, 0f, blockHeight, BLACK, currentColor, TileMode.CLAMP)
        val paintRed = Paint()
        paintRed.shader = shader
        canvas?.drawRect(0.0f, 0.0f, CodeUtils.getWidthPixels(context).toFloat(), blockHeight, paintRed);


//        paint.setColor(Color.GREEN);
//        paint.setStrokeWidth(3.0f);
//        canvas?.drawRect(0.0f, 2 * blockHeight, CodeUtils.getWidthPixels(context).toFloat(), blockHeight, paint)
//
//
//        paint.setColor(Color.BLUE);
//        paint.setStrokeWidth(3.0f);
//        canvas?.drawRect(0.0f, 3 * blockHeight, CodeUtils.getWidthPixels(context).toFloat(), 2 * blockHeight, paint);


    }

}