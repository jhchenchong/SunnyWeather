package com.sunnyweather.study.android.logic.network

import com.sunnyweather.study.android.SunnyWeatherApplication
import com.sunnyweather.study.android.logic.model.DailyResponse
import com.sunnyweather.study.android.logic.model.RealtimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WertherService {

    @GET("v2.5/${SunnyWeatherApplication.TOKEN}/{lng},{lat}/realtime.json")
    fun getRealtieWeather(@Path("lng") lng: String, @Path("lat") lat: String) : Call<RealtimeResponse>

    @GET("v2.5/${SunnyWeatherApplication.TOKEN}/{lng},{lat}/daily.json")
    fun getDailyWeather(@Path("lng") lng: String, @Path("lat") lat: String) : Call<DailyResponse>
}