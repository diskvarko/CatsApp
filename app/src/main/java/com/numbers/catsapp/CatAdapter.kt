package com.numbers.catsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CatAdapter(context: Context) :
    RecyclerView.Adapter<CatViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var cats: List<CatResponse> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        return CatViewHolder(inflater.inflate(R.layout.cat_item, parent, false))
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bind(cats[position])

    }

    override fun getItemCount(): Int = cats.size

  // fun getItem(position: Int): CatResponse = cats[position]

    fun setCatsList(newList: List<CatResponse>) {
        cats = newList
        notifyDataSetChanged()
    }
}