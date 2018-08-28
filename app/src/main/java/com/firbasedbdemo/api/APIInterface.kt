package com.firbasedbdemo.api

import com.google.gson.JsonElement
import io.reactivex.Single
import retrofit2.http.GET

interface APIInterface {
    @GET("locations.json")
    fun getCarList(): Single<JsonElement>
}