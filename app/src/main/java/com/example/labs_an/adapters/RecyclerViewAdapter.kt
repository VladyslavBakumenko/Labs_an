package com.example.labs_an.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.labs_an.ProductData
import com.example.labs_an.databinding.RecyclerViewItemBinding

class RecyclerViewAdapter(
    private val printerListener: (printer: String, cost: Int) -> Unit,
) :
    ListAdapter<ProductData, RecyclerViewViewHolder>(RecyclerViewDiffCallBack()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewViewHolder {
        val binding = RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context))
        return RecyclerViewViewHolder(binding, printerListener)
    }

    override fun onBindViewHolder(holder: RecyclerViewViewHolder, position: Int) {
        currentList[position].let {
            holder.onBind(it)
        }
    }
}