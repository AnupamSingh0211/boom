package com.hala.boom

import android.content.Context
import android.graphics.*
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

class CircularView : View {


    var mPaint = Paint()
    var blockHeight: Float = 0.0f
    var screenWidth: Float = 0.0f
    var screenHeight: Float = 0.0f
    var startingHeight = 0.0f
    var colorArray: IntArray
    var startingColor: Int
    var endingColor: Int
    lateinit var shader: Shader
    lateinit var shader1: Shader
    val paintRed = Paint()
    var randomX: Int
    var randomY: Int

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
        colorArray = intArrayOf(Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.YELLOW)
        startingColor = colorArray[0]
        endingColor = Color.CYAN
        screenHeight = (CodeUtils.getHeightPixels(context)).toFloat()
        screenWidth = (CodeUtils.getWidthPixels(context)).toFloat()
        randomX = getRandomXValue()
        randomY = getRandomYValue()
    }

    private fun getRandomXValue(): Int {
        return Random.nextInt(100, (screenWidth - 100).toInt())

    }

    private fun getRandomYValue(): Int {
        return Random.nextInt(100, (screenHeight - 100).toInt())

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

//        mPaint.setColor(Color.RED);
//        mPaint.setStrokeWidth(3.0f);
//        canvas?.drawRect(0.0f, 0.0f, CodeUtils.getWidthPixels(context).toFloat(), blockHeight, mPaint);

//
        if (startingHeight >= blockHeight / 6) {
            startingHeight = 1.0f
            startingColor = endingColor
            endingColor = colorArray[Random.nextInt(0, 5)]

            if (startingColor == endingColor)
                endingColor = Color.RED

            randomX = getRandomXValue()
            randomY = getRandomYValue()

        } else
            startingHeight = startingHeight + 10.0f


////
        shader = RadialGradient(
            randomX.toFloat(),
            randomY.toFloat(),
            startingHeight,
            startingColor,
            Color.BLACK,
            Shader.TileMode.CLAMP
        );
//        shader = SweepGradient(0f, startingHeight, 0f, blockHeight+100, endingColor, startingColor, TileMode.CLAMP)
        paintRed.shader = shader

        canvas?.drawCircle(randomX.toFloat(), randomY.toFloat(), startingHeight, paintRed)



//        shader1 = RadialGradient(
//            screenWidth / 2,
//            screenHeight / 2,
//            startingHeight,
//            endingColor,
//            startingColor,
//            Shader.TileMode.CLAMP
//        );
////        shader = SweepGradient(0f, startingHeight, 0f, blockHeight+100, endingColor, startingColor, TileMode.CLAMP)
//        mPaint.shader = shader1
//
//
//
//        canvas?.drawCircle(randomY.toFloat()-20.0f, randomX.toFloat(), startingHeight, mPaint)


    }

}