package com.gricob.marsroverphotos.repository.network

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MarsRoverService {

    interface CallbackResponse<T> {
        fun onResponse(response: T)
        fun onFailure(t: Throwable, res: Response<*>? = null)
    }

    val marsRoverApi: MarsRoverApi

    init {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.nasa.gov/mars-photos/api/v1/")
            .build()

        marsRoverApi = retrofit.create(MarsRoverApi::class.java)

    }
}