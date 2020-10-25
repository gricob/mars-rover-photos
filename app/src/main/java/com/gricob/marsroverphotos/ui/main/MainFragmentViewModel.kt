package com.gricob.marsroverphotos.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.gricob.marsroverphotos.repository.db.MarsRoverRoomDatabase
import com.gricob.marsroverphotos.repository.model.PhotosItem

class MainFragmentViewModel(private val context: Application) : ViewModel() {
    fun getAllPhotos(): LiveData<List<PhotosItem>> {
        return MarsRoverRoomDatabase.getInstance(context).marsRoverDao().getAllPhotos()
    }
}