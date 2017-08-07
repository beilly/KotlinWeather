package com.benli.cmm.network.converter


import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.reflect.Type


/**
 * retrofit转换成字符串支持
 * Created by shibenli on 2017/8/7.
 */
class StringConverterFactory : Converter.Factory() {

    override fun responseBodyConverter(type: Type, annotations: Array<Annotation>, retrofit: Retrofit): Converter<ResponseBody, *> {
        return ConfigurationServiceConverter()
    }

    internal inner class ConfigurationServiceConverter : Converter<ResponseBody, String> {

        @Throws(IOException::class)
        override fun convert(value: ResponseBody): String {
            val r = BufferedReader(InputStreamReader(value.byteStream()))
            val total = StringBuilder()
            r.forEachLine {
                total.append(it)
            }
//            var line: String? = null
//            while ({ line = r.readLine(); line }() != null) {
//                total.append(line)
//            }

            return total.toString()
        }
    }

    companion object {
        fun create(): StringConverterFactory {
            return StringConverterFactory()
        }
    }
}