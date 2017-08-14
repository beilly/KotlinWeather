package com.benli.kotlinweather.globel

import android.graphics.Typeface
import com.benli.cmm.globle.CompanionObj
import com.benli.cmm.globle.App as BaseApp

/**
 * Created by shibenli on 2017/8/14.
 */
open class App: BaseApp(){

    override fun onCreate() {
        super.onCreate()
        iconTypeFace = Typeface.createFromAsset(assets, "fonts/weathericons-regular-webfont.ttf")
    }

    companion object: CompanionObj() {
        lateinit var iconTypeFace: Typeface
    }
}