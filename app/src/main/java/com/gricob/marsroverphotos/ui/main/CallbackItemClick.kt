package com.gricob.marsroverphotos.ui.main

import com.gricob.marsroverphotos.repository.model.PhotosItem

interface CallbackItemClick {
    fun onItemClick(photosItem: PhotosItem)
}