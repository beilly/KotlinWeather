package com.benli.kotlinweather.main.weather.viewmodel

import android.content.Context
import android.databinding.ObservableField
import android.view.View
import com.benli.cmm.ex.LOG_D
import com.benli.cmm.ex.showToast
import com.benli.cmm.network.RetrofitClient
import com.benli.common.base.BaseViewModel
import com.benli.kotlinweather.BR
import com.benli.kotlinweather.main.weather.model.WeatherData
import com.benli.kotlinweather.network.WeatherServer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by shibenli on 2017/8/8.
 */
class WeatherViewModel(var context: Context): BaseViewModel() {
    var lat: Double = 31.22
    var lon: Double = 121.48

    var weather: ObservableField<WeatherData> = ObservableField()

    init {
        refreshWeather()
    }

    /**
     * 加新城市的点击事件
     */
    fun onAddClick(view: View){
        refreshWeather()
    }

    fun refreshWeather() {
        RetrofitClient.getInstance(context, WeatherServer.BASE_URL)
                .create(WeatherServer::class.java)
                .get5Day(lat = lat.toString(), lon = lon.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    context.showToast("Get Top Weather")
                    weather.set(it)
                    weather.notifyChange()
                    LOG_D(it)
                }, {
                    context.showToast(it.localizedMessage)
                },{
                    context.showToast("Get Top Weather Completed")
                })
    }
}