package com.tt.lvruheng.eyepetizer.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.Gravity
import android.widget.Toast
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.tt.lvruheng.eyepetizer.globle.App

/**
 * Created by lvruheng on 2017/7/2.
 */
fun Context.showToast(message: String) : Toast {
    var toast : Toast = Toast.makeText(this,message,Toast.LENGTH_SHORT)
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
fun <T> Observable<T>.applySchedulers(): Observable<T> {
    return subscribeOn(Schedulers.io()).
            unsubscribeOn(Schedulers.io()).
            observeOn(AndroidSchedulers.mainThread())
}

public val Double.px: Int
    get() = (this * App.displayMetrics.density + 0.5f).toInt()


public val Double.dp: Int
    get() = (this / App.displayMetrics.density + 0.5f).toInt()





