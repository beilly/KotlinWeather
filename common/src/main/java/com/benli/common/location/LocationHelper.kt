package com.benli.common.location

import com.amap.api.location.AMapLocationClient
import com.amap.api.location.AMapLocationClientOption
import com.amap.api.location.AMapLocationListener

import android.content.Context
import com.benli.cmm.globle.App

/**
 * @author baidu
 */
class LocationHelper
/***
 * @param locationContext
 */
private constructor(locationContext: Context) {
    var client: AMapLocationClient? = null

    private val objLock = Any()

    init {
        synchronized(objLock) {
            if (client == null) {
                client = AMapLocationClient(locationContext.applicationContext)
                client!!.setLocationOption(defaultLocationClientOption)
            }
        }
    }

    /***
     * @param listener
     * *
     * @return
     */

    fun registerListener(listener: AMapLocationListener?): Boolean {
        var isSuccess = false
        if (listener != null) {
            client!!.setLocationListener(listener)
            isSuccess = true
        }
        return isSuccess
    }

    fun unregisterListener(listener: AMapLocationListener?) {
        if (listener != null) {
            client!!.unRegisterLocationListener(listener)
        }
    }

    /***
     * @return DefaultLocationClientOption
     */
    //设置返回地址信息，默认为true
    //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
    //设置定位间隔,单位毫秒,默认为2000ms
    //设置缓存定位数据
    val defaultLocationClientOption: AMapLocationClientOption by lazy{
            val mOption = AMapLocationClientOption()
            mOption.isNeedAddress = true
            mOption.locationMode = AMapLocationClientOption.AMapLocationMode.Battery_Saving
            mOption.interval = 2000
            mOption.isLocationCacheEnable = true
            mOption
        }

    fun start() {
        synchronized(objLock) {
            if (client != null && !client!!.isStarted) {
                client!!.startLocation()
            }
        }
    }

    fun stop() {
        synchronized(objLock) {
            if (client != null && client!!.isStarted) {
                client!!.stopLocation()
            }
        }
    }

    companion object {

        val instance: LocationHelper by lazy {
            LocationHelper(App.app)
        }
    }

}
