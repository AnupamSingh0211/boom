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

class CircularBoomView : View {


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
        if (startingHeight >= blockHeight/4) {
            startingHeight = 1.0f
            startingColor = endingColor
            endingColor = colorArray[Random.nextInt(0, 5)]

            if (startingColor == endingColor)
                endingColor = Color.BLACK


        } else
            startingHeight = startingHeight + 10.0f
//
//        shader = RadialGradient(screenWidth/2, screenHeight/2, startingHeight, startingColor, Color.CYAN,Shader.TileMode.CLAMP);
////        shader = SweepGradient(0f, startingHeight, 0f, blockHeight+100, endingColor, startingColor, TileMode.CLAMP)
//        paintRed.shader = shader
//        canvas?.drawCircle(0.0f, 0.0f, blockHeight/5, paintRed);
//


//        val shader = SweepGradient(startingHeight / 2, (startingHeight / 2).toFloat(), colorArray, null)
//        mPaint.setShader(shader)
//        canvas?.drawCircle(screenWidth / 10, screenHeight / 10, 1.0f, mPaint)

//
//        if (mPaint == null) {
//            mPaint = Paint()
//            mPaint.setColor(Color.GREEN)
//            mPaint.setStrokeWidth(1.0f)
//            mPaint.setStyle(Paint.Style.FILL_AND_STROKE)
//            mPaint.setShader(
//                RadialGradient(
//                    (width / 2).toFloat(), (height / 2).toFloat(),
//                    (height / 3).toFloat(), Color.TRANSPARENT, Color.BLACK, TileMode.MIRROR
//                )
//            )
//        }
//
//        canvas?.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), (height / 3).toFloat(), mPaint)


        shader1 = RadialGradient(screenHeight/2, screenWidth/2, startingHeight, endingColor, Color.BLACK,Shader.TileMode.CLAMP)


//        shader = SweepGradient(0f, startingHeight, 0f, blockHeight+100, endingColor, startingColor, TileMode.CLAMP)
        mPaint.shader = shader1



        canvas?.drawRect(0.0f, 0.0f, CodeUtils.getWidthPixels(context).toFloat(), blockHeight/2, mPaint);
//



        shader = RadialGradient(screenWidth/2, 3*screenHeight/4, startingHeight, startingColor, Color.BLACK,Shader.TileMode.CLAMP)


//        shader = SweepGradient(0f, startingHeight, 0f, blockHeight+100, endingColor, startingColor, TileMode.CLAMP)
        paintRed.shader = shader



        canvas?.drawRect(0.0f, blockHeight, CodeUtils.getWidthPixels(context).toFloat(), blockHeight/2, paintRed);




//        mPaint.setColor(Color.GREEN);
//        mPaint.setStrokeWidth(3.0f);
//        canvas?.drawRect(0.0f, 2 * blockHeight, CodeUtils.getWidthPixels(context).toFloat(), blockHeight, mPaint)
//
//
//        mPaint.setColor(Color.BLUE);
//        mPaint.setStrokeWidth(3.0f);
//        canvas?.drawRect(0.0f, 3 * blockHeight, CodeUtils.getWidthPixels(context).toFloat(), 2 * blockHeight, mPaint);


    }

}