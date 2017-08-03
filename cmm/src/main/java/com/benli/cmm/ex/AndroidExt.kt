package com.benli.cmm.ex

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import com.shibenli.basecom.DEBUG
import com.shibenli.basecom.TAG
import org.apache.commons.lang3a.ArrayUtils

/**
 * Created by shibenli on 2017/8/2.
 */
fun Context.showToast(message: String) : Toast {
    var toast : Toast = Toast.makeText(this,message, Toast.LENGTH_SHORT)
    toast.setGravity(Gravity.CENTER,0,0)
    toast.show()
    toast?.apply{

    }
    return toast
}

inline fun <reified T: Activity> Activity.newIntent() {
    val intent = Intent(this, T::class.java)
    startActivity(intent)
}

/**
 * 统一的日志扩展
 */
public fun Any.LOG_D(vararg msg: Any): Int {
    var message: String
    if (ArrayUtils.isEmpty(msg)) {
        message = "null or empty msg!"
    } else {
        try {
            message = String.format(msg[0].toString(), ArrayUtils.subarray(msg, 1, msg.size))
        } catch (e: Exception) {
            message = msg.toString()
        }

    }

    return LOG_D(message)
}

/**
 * 统一自定义log，建议使用

 * @param paramClass getClass()或xxx.class
 * *
 * @param param      需要打印Object
 */
public fun Any.LOG_D(param: Any): Int {
    // 只有debug模式才打印log
    if (DEBUG) {
        val paramString = param.toString()
        var str: String? = this.javaClass.name
        if (str != null) {
            str = str.substring(1 + str.lastIndexOf("."))
        }
        val i = paramString.length
        if (i > LOG_SIZE_LIMIT) {
            var j = 0
            val k = 1 + i / LOG_SIZE_LIMIT
            while (j < k + -1) {
                Log.d(TAG, paramString.substring(j * LOG_SIZE_LIMIT,
                        LOG_SIZE_LIMIT * (j + 1)))
                j++
            }
            return Log.d(TAG, paramString.substring(j * LOG_SIZE_LIMIT, i))
        } else {
            return Log.d(TAG, str + " -> " + paramString)
        }
    }
    return 0
}

private val LOG_SIZE_LIMIT = 3500
