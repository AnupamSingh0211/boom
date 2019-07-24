package com.hala.boom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View


/**
 * @author Anupam Singh
 * @version 1.0
 * @since 2019-07-24
 */

class BoomView : View {


    var paint = Paint()
    var blockHeight: Float = 0.0f

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
        blockHeight = (CodeUtils.getHeightPixels(context) / 3).toFloat()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.setColor(Color.RED);
        paint.setStrokeWidth(3.0f);
        canvas?.drawRect(0.0f, 0.0f, CodeUtils.getWidthPixels(context).toFloat(), blockHeight, paint);


        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(3.0f);
        canvas?.drawRect(0.0f, 2 * blockHeight, CodeUtils.getWidthPixels(context).toFloat(), blockHeight, paint)


        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(3.0f);
        canvas?.drawRect(0.0f, 3 * blockHeight, CodeUtils.getWidthPixels(context).toFloat(), 2 * blockHeight, paint);


    }

}