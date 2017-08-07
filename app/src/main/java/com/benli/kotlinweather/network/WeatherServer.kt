package com.benli.kotlinweather.network

import com.benli.kotlinweather.BuildConfig
import com.benli.kotlinweather.main.weather.model.WeatherData
import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by shibenli on 2017/8/7.
 */
interface WeatherServer {
    companion object{
        val BASE_URL : String
            get() = "http://api.openweathermap.org/data/2.5/"


    }

    /**
     * 根据城市id来获取天气信息
     */
    @GET("forecast")
    fun get5Day(@Query("id") id: String, @Query("appid") appid: String = BuildConfig.APPID)
            : Observable<JsonObject>

    /**
     * 根据经纬度来获取天气
     * @param lat 纬度
     * @param lon 经度
     */
    @GET("forecast")
    fun get5Day(@Query("lat") lat: String, @Query("lon") lon: String
                , @Query("appid") appid: String = BuildConfig.APPID): Observable<WeatherData>
}