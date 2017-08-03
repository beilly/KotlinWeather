package com.benli.kotlinweather.main.launcher.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.PersistableBundle
import com.benli.cmm.base.CMActivity
import com.benli.kotlinweather.BR
import com.benli.kotlinweather.R
import com.benli.kotlinweather.databinding.LauncherActivityBinding
import com.benli.kotlinweather.main.launcher.viewmodel.LaunchViewModel

/**
 * Created by shibenli on 2017/8/2.
 */
class LauncherActivity: CMActivity() {
    lateinit var activityBinding: LauncherActivityBinding
    lateinit var viewModel: LaunchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = DataBindingUtil.setContentView<LauncherActivityBinding>(this, R.layout.launcher_activity)
        viewModel = LaunchViewModel(this)
        activityBinding.setVariable(BR.viewModel, viewModel)
    }
}