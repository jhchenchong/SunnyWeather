package com.sunnyweather.study.android.logic.model

data class Weather(val realtime: RealtimeResponse.Realtime, val daily: DailyResponse.Daily);