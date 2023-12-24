package com.example.labs_an.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.labs_an.ProductData
import com.example.labs_an.databinding.RecyclerViewItemBinding

class RecyclerViewViewHolder(
    private val binding: RecyclerViewItemBinding,
    private val minusListener: (productData: ProductData) -> Unit,
    private val plusListener: (productData: ProductData) -> Unit

) : RecyclerView.ViewHolder(binding.root) {

    private var count = 0

    fun onBind(productData: ProductData) {
        with(binding) {
            tvPlaceName.text = productData.product
            image.setImageResource(productData.image)
            cost.text = "Ціна = ${productData.cost}"
            tvSelected.text = count.toString()
            imagePlus.setOnClickListener {
                if (count == 0) {
                    count++
                }
                binding.imageMinus
                tvSelected.text = count.toString()
                plusListener(productData)
            }
            imageMinus.setOnClickListener {
                if (count == 1) {
                    count--
                }
                tvSelected.text = count.toString()
                minusListener(productData)
            }
        }
    }
}