package com.gricob.marsroverphotos.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.gricob.marsroverphotos.R
import com.gricob.marsroverphotos.repository.model.PhotosItem
import kotlinx.android.synthetic.main.photos_item_list.view.*

class MainAdapter(
    private val context: Context,
    private val callbackItemClick: CallbackItemClick?,
    private val items: List<PhotosItem>
    ) : RecyclerView.Adapter<MainAdapter.MainHolder>() {

    class MainHolder(v: View): RecyclerView.ViewHolder(v) {
        internal var view = v
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photos_item_list, parent, false)

        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        items.get(position).let { item ->
            Glide.with(context)
                .load(item.imgSrc)
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_foreground)
                )
                .into(holder.view.cardViewImage)

            holder.view.cardView.setOnClickListener {
                callbackItemClick?.onItemClick(item)
            }

            holder.view.cardViewTitle.text = item.camera?.let {
                it.name + " / " + item.earthDate
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}