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
        var cod: Int = 400,
        var message: Double = 0.toDouble(),
        var cnt: Int = 0,
        var list: List<HourWeather>? = null,
        var city: City? = null
)

data class Wind(
        var speed: Double = 0.toDouble(),
        var deg: Double = 0.toDouble()
)

data class Weather(
        var id: Int = 0,
        var main: String = "",
        var description: String = "",
        var icon: String = ""
)

data class City(
        var id: Int = 0,
        var name: String = "",
        var coord: Coord? = null,
        var country: String = ""
)

data class Clouds(
        var all: Int = 0
)

data class Coord(
        var lat: Double = 0.toDouble(),
        var lon: Double = 0.toDouble()
)

data class HourWeather(
        var dt: Int = 0,
        var main: Main? = null,
        var weather: List<Weather>? = null,
        var clouds: Clouds? = null,
        var wind: Wind? = null,
        var sys: Sys? = null,
        var dt_txt: String = ""
)

data class Main(
        var temp: Double = 0.toDouble(),
        var temp_min: Double = 0.toDouble(),
        var temp_max: Double = 0.toDouble(),
        var pressure: Double = 0.toDouble(),
        var sea_level: Double = 0.toDouble(),
        var grnd_level: Double = 0.toDouble(),
        var humidity: Int = 0,
        var temp_kf: Double = 0.toDouble()
)

data class Sys(
        var pod: String = ""
)