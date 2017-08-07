package com.benli.kotlinweather.main.weather.ui

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.benli.cmm.base.CMActivity
import com.benli.cmm.ex.LOG_D
import com.benli.cmm.ex.showToast
import com.benli.cmm.network.RetrofitClient
import com.benli.kotlinweather.R
import com.benli.kotlinweather.network.WeatherServer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_weather.*

class WeatherActivity : CMActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        toolbar.title = getString(R.string.title_activity_weather)
        fab.setOnClickListener {
            RetrofitClient.getInstance(this, WeatherServer.BASE_URL)
                    .create(WeatherServer::class.java)
                    .get5Day(lat = "31.22", lon = "121.48")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                            showToast("Get Top Movie Completed")
                            LOG_D(it)
                        }, {
                            showToast(it.localizedMessage)
                        },{
                            showToast(it.toString())
                        }
                    )
        }
    }
}
