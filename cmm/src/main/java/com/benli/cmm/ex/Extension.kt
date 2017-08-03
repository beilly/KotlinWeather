package com.benli.cmm.ex

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.tt.lvruheng.eyepetizer.globle.App

/**
 * Created by lvruheng on 2017/7/2.
 */

fun <T> Observable<T>.applySchedulers(): Observable<T> {
    return subscribeOn(Schedulers.io()).
            unsubscribeOn(Schedulers.io()).
            observeOn(AndroidSchedulers.mainThread())
}

public val Double.px: Int
    get() = (this * App.displayMetrics.density + 0.5f).toInt()


public val Double.dp: Int
    get() = (this / App.displayMetrics.density + 0.5f).toInt()



inline  fun checkNotNull(vararg parms: Any?, doThing: () -> Unit){
    parms.let {
        loop@ for (any in parms){
            when(any){
                null -> return
                else -> continue@loop
            }
        }

        doThing()
    }
}