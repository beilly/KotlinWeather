package com.benli.common

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.layout_forecast_view.view.*

/**
 * Created by shibenli on 2017/8/29.
 */
open class ForecastView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0,
                                                      defStyleRes: Int = 0) : RelativeLayout(context, attrs, defStyleAttr, defStyleRes) {
    init {
        LayoutInflater.from(context).inflate(R.layout.layout_forecast_view, this, true)
        initView(attrs)
    }

    protected open fun initView(attrs: AttributeSet? = null){
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ForecastView)

            val time = typedArray.getString(R.styleable.ForecastView_fcv_time)
            val icon = typedArray.getString(R.styleable.ForecastView_fcv_icon)
            val temperature = typedArray.getString(R.styleable.ForecastView_fcv_temperature)
            tvTime.text = time
            tvIcon.text = icon
            tvTemperature.text = temperature

            typedArray.recycle()
        }
    }
}