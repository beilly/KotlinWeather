package com.tt.lvruheng.eyepetizer.utils

import android.content.Context
import android.widget.ImageView
import com.benli.cmm.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.bumptech.glide.request.RequestOptions


/**
 * Created by lvruheng on 2017/7/6.
 */

val options = RequestOptions()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .centerCrop()
        .placeholder(R.drawable.ic_image_loading)
        .error(R.drawable.ic_empty_picture)

val optionsHigh = RequestOptions()
        .format(DecodeFormat.PREFER_ARGB_8888)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .centerCrop()
        .placeholder(R.drawable.ic_image_loading)
        .error(R.drawable.ic_empty_picture)

fun display(imageView: ImageView, context: Context = imageView.context, url: String?) {
    Glide.with(context).load(url)
            .apply(options)
            .into(imageView)
}

fun displayHigh(imageView: ImageView, context: Context = imageView.context, url: String?) {
    Glide.with(context).asBitmap()
            .load(url)
            .apply(optionsHigh)
            .transition(BitmapTransitionOptions.withCrossFade())
            .into(imageView)
}
