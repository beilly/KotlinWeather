package com.tt.lvruheng.eyepetizer.globle

import android.app.Application
import android.util.DisplayMetrics

/**
 * Created by shibenli on 2017/7/31.
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        app = this
        displayMetrics = resources.displayMetrics
    }

    companion object {
        lateinit var app : App
        lateinit var displayMetrics: DisplayMetrics
    }
}
