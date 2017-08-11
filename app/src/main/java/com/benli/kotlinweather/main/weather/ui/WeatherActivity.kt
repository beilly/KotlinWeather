package com.benli.kotlinweather.main.weather.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.benli.cmm.base.CMActivity
import com.benli.kotlinweather.R
import com.benli.kotlinweather.databinding.ActivityWeatherBinding
import com.benli.kotlinweather.main.weather.viewmodel.WeatherViewModel
import kotlinx.android.synthetic.main.activity_weather.*

class WeatherActivity : CMActivity() {
    lateinit var weatherBind: ActivityWeatherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        weatherBind = DataBindingUtil.setContentView<ActivityWeatherBinding>(this, R.layout.activity_weather)
        weatherBind.weatherVM = WeatherViewModel(this)
        toolbar.title = getString(R.string.title_activity_weather)
    }
}
