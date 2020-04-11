package com.sunnyweather.study.android.logic

import android.app.DownloadManager
import android.util.Log
import androidx.lifecycle.liveData
import com.sunnyweather.study.android.logic.model.Place
import com.sunnyweather.study.android.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import java.lang.RuntimeException

object Repository {
    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
            if (placeResponse.status == "ok") {
                val places = placeResponse.places
                Log.d("Repository", "${places}")
                Result.success(places)
            } else {
                Log.e("Repository", "${placeResponse.status}")
                Result.failure(RuntimeException("Responce status is ${placeResponse.status}"))
            }
        } catch (e: Exception) {
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}