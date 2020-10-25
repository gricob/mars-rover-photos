package com.gricob.marsroverphotos.utils

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gricob.marsroverphotos.ui.main.MainFragmentViewModel
import java.lang.IllegalArgumentException

class CustomViewModelFactory(private val application: Application)
    : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return with(modelClass) {
            when {
                isAssignableFrom(MainFragmentViewModel::class.java) -> MainFragmentViewModel(application)
                else -> throw IllegalArgumentException("Unknown view model")
            }
        } as T
    }
}