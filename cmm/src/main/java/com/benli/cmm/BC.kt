package com.shibenli.basecom

import com.benli.cmm.ex.dp

/**
 * Created by shibenli on 2017/7/4.
 */

var TAG = "TAG"
    get private set

var DEBUG :Boolean= true
    get private set

@JvmOverloads fun init(tag :String = "TAG", debug: Boolean = false) {
    TAG = tag
    DEBUG = debug
}

fun test(){
    val tDp = 2.0.dp
}

fun main(args: Array<String>) {
    test()
    println(listOf(1, 2, 3, 4).fold(0, {
        partProduct, element ->
        element * partProduct
    }))
}