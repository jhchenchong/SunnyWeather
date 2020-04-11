package com.sunnyweather.study.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class SunnyWeatherApplication : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        const val TOKEN = "4rL43Xy9VWoakxhn"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}