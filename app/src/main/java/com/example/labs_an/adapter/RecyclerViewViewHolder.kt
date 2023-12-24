package com.example.labs_an.adapter

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
            ivMinus.visibility = View.INVISIBLE
            ivPlus.visibility = View.INVISIBLE
            tvProductName.text = productData.product
            tvProductCost.text = "Cost = ${productData.cost}"
            ivMinus.setOnClickListener {
                if (selectedItems != 0) {
                    selectedItems--
                    tvProductQuantity.text = "Selected items count = $selectedItems"
                }
            }
            ivPlus.setOnClickListener {
                selectedItems++
                tvProductQuantity.text = "Selected items count = $selectedItems"
            }
        }
    }
}