package com.gricob.marsroverphotos.repository.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.gricob.marsroverphotos.repository.model.PhotosItem

@Dao
abstract class MarsRoverDao {
    @Query("SELECT * FROM photos_table")
    abstract fun getAllPhotos(): LiveData<List<PhotosItem>>

    @Query("SELECT * FROM photos_table")
    abstract fun getAll(): List<PhotosItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertPhoto(photoItem: PhotosItem)

    @Delete
    abstract fun deletePhoto(photoItem: PhotosItem)
}