package com.example.labs_an.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.labs_an.ProductData
import com.example.labs_an.databinding.RecyclerViewItemBinding

class RecyclerViewViewHolder(
    private val binding: RecyclerViewItemBinding,
    private val selectedListener: (state: Boolean, placeName: String) -> Unit

) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(productData: ProductData) {
        with(binding) {
            tvPlaceName.text = productData.product
            image.setImageResource(productData.image)
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                selectedListener(isChecked, productData.product)
            }
        }
    }
}