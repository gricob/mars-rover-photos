package com.gricob.marsroverphotos.repository.network

import com.gricob.marsroverphotos.repository.model.PhotosResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MarsRoverApi {

    @GET("rovers/curiosity/photos")
    @Headers("Content-Type: application/json")
    fun getPhotos(@Query("api_key") apiKey: String, @Query("sol") sol: Int): Call<PhotosResponse>
}