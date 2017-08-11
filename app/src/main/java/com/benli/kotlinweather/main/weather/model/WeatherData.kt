/**
 * Copyright 2017 bejson.com
 */
package com.benli.kotlinweather.main.weather.model

import android.databinding.BaseObservable
import android.databinding.Bindable

/**
 * Auto-generated: 2017-08-07 16:36:47

 * @author bejson.com (i@bejson.com)
 * *
 * @website http://www.bejson.com/java2pojo/
 */
data class WeatherData(
        @get:Bindable var cod: String = "",
        @get:Bindable var message: Double = 0.toDouble(),
        @get:Bindable var cnt: Int = 0,
        @get:Bindable var list: List<HourWeather>? = null,
        @get:Bindable var city: City? = null
): BaseObservable()

data class Wind(
        @get:Bindable var speed: Double = 0.toDouble(),
        @get:Bindable var deg: Double = 0.toDouble()
): BaseObservable()

data class Weather(
        @get:Bindable var id: Int = 0,
        @get:Bindable var main: String = "",
        @get:Bindable var description: String = "",
        @get:Bindable var icon: String = ""
): BaseObservable()

data class City(
        @get:Bindable var id: Int = 0,
        @get:Bindable var name: String = "",
        @get:Bindable var coord: Coord? = null,
        @get:Bindable var country: String = ""
): BaseObservable()

data class Clouds(
        @get:Bindable var all: Int = 0
): BaseObservable()

data class Coord(
        @get:Bindable var lat: Double = 0.toDouble(),
        @get:Bindable var lon: Double = 0.toDouble()
): BaseObservable()

data class HourWeather(
        @get:Bindable var dt: Int = 0,
        @get:Bindable var main: Main? = null,
        @get:Bindable var weather: List<Weather>? = null,
        @get:Bindable var clouds: Clouds? = null,
        @get:Bindable var wind: Wind? = null,
        @get:Bindable var sys: Sys? = null,
        @get:Bindable var dt_txt: String = ""
): BaseObservable()

data class Main(
        @get:Bindable var temp: Double = 0.toDouble(),
        @get:Bindable var temp_min: Double = 0.toDouble(),
        @get:Bindable var temp_max: Double = 0.toDouble(),
        @get:Bindable var pressure: Double = 0.toDouble(),
        @get:Bindable var sea_level: Double = 0.toDouble(),
        @get:Bindable var grnd_level: Double = 0.toDouble(),
        @get:Bindable var humidity: Int = 0,
        @get:Bindable var temp_kf: Double = 0.toDouble()
): BaseObservable()

data class Sys(
        @get:Bindable var pod: String = ""
): BaseObservable()