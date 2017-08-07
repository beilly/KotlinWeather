package com.benli.kotlinweather.main.launcher.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.PersistableBundle
import com.benli.cmm.base.CMActivity
import com.benli.cmm.ex.LOG_D
import com.benli.cmm.ex.newIntent
import com.benli.kotlinweather.BR
import com.benli.kotlinweather.R
import com.benli.kotlinweather.databinding.LauncherActivityBinding
import com.benli.kotlinweather.main.launcher.viewmodel.LaunchViewModel
import com.benli.kotlinweather.main.weather.ui.WeatherActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import java.util.concurrent.TimeUnit

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
        Observable.timer(1000 * 2, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    LOG_D()
                    val bundle = Bundle()
                    bundle.putLong("time", it)
                    newIntent<WeatherActivity>(bundle)
                    finish()
                })
    }

}