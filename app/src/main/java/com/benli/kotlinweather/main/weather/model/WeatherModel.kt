package com.benli.kotlinweather.main.weather.model

/**
 * Created by shibenli on 2017/8/14.
 */
data class WeatherModel(
        val lcation: String = "",
        val forecasts: List<Forecast>
)

data class Forecast(
        val time: String = "",
        val iconText: String = "",
        val temperature: String = ""
)

fun temperature(country: String, openWeatherMapDegrees: Double): String {
    val degrees: String
    if (country == "US") {
        degrees = kelvinToFahrenheit(openWeatherMapDegrees).toString() + "\uf045"
    } else {
        degrees = kelvinToCelsius(openWeatherMapDegrees).toString() + "\uf03c"
    }

    return degrees
}

fun kelvinToCelsius(degrees: Double): Long {
    return Math.round(degrees - 273.15)
}

fun kelvinToFahrenheit(degrees: Double): Long {
    return Math.round(degrees * 9 / 5 - 459.67)
}