package com.sunnyweather.study.android.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sunnyweather.study.android.logic.Repository
import com.sunnyweather.study.android.logic.model.Place

class PlaceViewModel : ViewModel() {

    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData) {query ->
        Repository.searchPlaces(query)
    }

    fun seachPlaces(query: String) {
        searchLiveData.value = query
    }
}