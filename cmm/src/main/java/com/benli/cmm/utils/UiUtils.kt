package com.tt.lvruheng.eyepetizer.utils

import com.benli.cmm.ex.dp
import com.benli.cmm.ex.px

/**
 * Created by lvruheng on 2017/7/4.
 */
object UiUtils{
    fun dip2px(dipValue:Double): Int{
        return dipValue.px
    }
    fun px2dip(pxValue : Double): Int{
        return pxValue.dp
    }
}