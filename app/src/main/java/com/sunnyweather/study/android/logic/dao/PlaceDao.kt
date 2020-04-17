package com.sunnyweather.study.android.logic.dao

import android.content.Context
import android.util.Log
import androidx.core.content.edit
import com.google.gson.Gson
import com.sunnyweather.study.android.SunnyWeatherApplication
import com.sunnyweather.study.android.logic.model.Place

object PlaceDao {

    private  const val  placeCacheKey = "place"

    fun savePlace(place: Place) {
        sharedPreferences().edit() {
            putString(placeCacheKey, Gson().toJson(place))
        }
    }

    fun getSavedPlace(): Place {
        val placeJson = sharedPreferences().getString(placeCacheKey, "")
        return Gson().fromJson(placeJson, Place::class.java)
    }

    fun isPlaceSaved() = sharedPreferences().contains(placeCacheKey)

    private fun sharedPreferences() = SunnyWeatherApplication.context.getSharedPreferences("sunny_weather", Context.MODE_PRIVATE)
}