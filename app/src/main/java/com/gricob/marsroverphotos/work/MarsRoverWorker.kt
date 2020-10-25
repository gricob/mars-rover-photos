package com.gricob.marsroverphotos.work

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.gricob.marsroverphotos.repository.db.MarsRoverRoomDatabase
import com.gricob.marsroverphotos.repository.model.PhotosResponse
import com.gricob.marsroverphotos.repository.network.MarsRoverService
import com.gricob.marsroverphotos.utils.ApiKey
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MarsRoverWorker(private val context: Context, workerParams: WorkerParameters): Worker(context, workerParams) {
    override fun doWork(): Result {

        MarsRoverService().marsRoverApi.getPhotos(ApiKey.API_KEY, 1000)
            .enqueue(object : Callback<PhotosResponse> {
                override fun onResponse(
                    call: Call<PhotosResponse>,
                    response: Response<PhotosResponse>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        val photosResponse = response.body()

                        photosResponse!!.photos?.forEach {
                            it?.let {
                                MarsRoverRoomDatabase.getInstance(applicationContext)
                                    .marsRoverDao().insertPhoto(it)
                            }
                        }

                    }
                }

                override fun onFailure(call: Call<PhotosResponse>, t: Throwable) {
                    Log.w("API", t.localizedMessage!!)
                }
            })

        return Result.success()

    }
}