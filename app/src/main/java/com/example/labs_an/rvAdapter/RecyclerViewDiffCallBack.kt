package com.example.labs_an.rvAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.labs_an.Application

class RecyclerViewDiffCallBack : DiffUtil.ItemCallback<Application>() {
    override fun areItemsTheSame(oldItem: Application, newItem: Application): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Application, newItem: Application): Boolean {
        return oldItem.id == newItem.id
    }
}