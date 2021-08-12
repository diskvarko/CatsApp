package com.numbers.catsapp

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop

class CatViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val imageCat: ImageView = view.findViewById(R.id.image_cat)

    fun bind(cat: CatResponse) {
        Glide.with(imageCat)
            .load(cat.imageUrl)
            .override(500, 500)
            .transform(CenterCrop())
            .placeholder(R.drawable.ic_baseline_android_24)
            .error(R.drawable.ic_baseline_broken_image_24)
            .into(imageCat)

    }
}