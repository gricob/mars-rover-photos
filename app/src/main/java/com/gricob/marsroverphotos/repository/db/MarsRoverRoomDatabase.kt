package com.gricob.marsroverphotos.repository.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gricob.marsroverphotos.repository.model.PhotosItem

@Database(entities = [PhotosItem::class], version = 1, exportSchema = false)
abstract class MarsRoverRoomDatabase: RoomDatabase() {

    abstract fun marsRoverDao(): MarsRoverDao

    companion object {

        private var instance: MarsRoverRoomDatabase? = null

        fun getInstance(context: Context): MarsRoverRoomDatabase {
            if (instance == null) {
                synchronized(MarsRoverRoomDatabase::class) {
                    instance = Room.databaseBuilder(context.applicationContext, MarsRoverRoomDatabase::class.java, "mars_rover_db")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            return instance!!
        }
    }
}