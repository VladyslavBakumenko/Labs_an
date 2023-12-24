package com.example.labs_an.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.labs_an.ProductData
import com.example.labs_an.databinding.RecyclerViewItemBinding

class RecyclerViewViewHolder(
    private val binding: RecyclerViewItemBinding,
    private val printerListener: (printer: String, cost: Int) -> Unit

) : RecyclerView.ViewHolder(binding.root) {

    private var selectedItems = 0

    fun onBind(productData: ProductData) {
        with(binding) {
            root.setOnClickListener {
                printerListener(productData.product, productData.cost)
            }
            tvProductName.text = productData.product
            tvProductCost.text = "Cost = ${productData.cost}"
            tvMadeDate.text = "Дата виготовлення: ${productData.madeDate}"
        }
    }
}