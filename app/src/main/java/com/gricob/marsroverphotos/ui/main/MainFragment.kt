package com.gricob.marsroverphotos.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.gricob.marsroverphotos.R
import com.gricob.marsroverphotos.repository.model.PhotosItem
import com.gricob.marsroverphotos.utils.CustomViewModelFactory
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : Fragment(), CallbackItemClick {

    companion object {
        fun newInstance() =  MainFragment()
    }

    private var mainAdapter: MainAdapter? = null

    private val mainViewModel: MainFragmentViewModel by lazy {
        val factory = CustomViewModelFactory(requireActivity().application)
        ViewModelProvider(this, factory).get(MainFragmentViewModel::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        getAllPhotos()
    }

    private fun init() {
        recyclerViewMainList.layoutManager = LinearLayoutManager(activity)
        recyclerViewMainList.isNestedScrollingEnabled = false
        recyclerViewMainList.setHasFixedSize(false)
    }

    private fun getAllPhotos() {
        mainViewModel.getAllPhotos().observe(viewLifecycleOwner, Observer { photosList ->
            mainAdapter = MainAdapter(requireActivity().applicationContext, this, photosList)

            recyclerViewMainList.adapter = mainAdapter
        })
    }

    override fun onItemClick(photosItem: PhotosItem) {
        TODO("Not yet implemented")
    }
}