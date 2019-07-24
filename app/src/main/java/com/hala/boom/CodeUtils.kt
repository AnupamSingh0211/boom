package com.hala.boom

import android.content.Context
import android.util.DisplayMetrics


/**
 * @author Anupam Singh
 * @version 1.0
 * @since 2019-07-24
 */

class CodeUtils {

    companion object {

        fun getDisplayMetric(context: Context): DisplayMetrics {
            return context.resources.displayMetrics
        }

//        @JvmStatic
//        fun dpToPx(dp: Int): Int {
//            return (dp * getDisplayMetric().density).toInt()
//        }


        fun getWidthPixels(context: Context): Int {
            return getDisplayMetric(context).widthPixels
        }

        fun getHeightPixels(context: Context): Int {
            return getDisplayMetric(context).heightPixels
        }

    }
}