package com.benli.kotlinweather.main.launcher.viewmodel

import android.content.Context
import com.benli.cmm.ex.LOG_D
import com.benli.common.base.BaseViewModel
import com.benli.kotlinweather.BuildConfig
import com.benli.kotlinweather.R
import com.benli.kotlinweather.main.launcher.model.LaunchData

/**
 * Created by shibenli on 2017/8/2.
 */
class LaunchViewModel(var context: Context): BaseViewModel() {
    var launch = LaunchData()

    init {
        launch.version = BuildConfig.VERSION_NAME
        launch.icon = R.mipmap.ic_launcher
        launch.name = context.getString(R.string.app_name)
    }

    override fun destroy() {
        LOG_D(this)
    }
}