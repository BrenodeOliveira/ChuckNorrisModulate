package com.breno.chuckmodularizate.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.breno.chuckmodularizate.databinding.CategoryItemBinding

internal class CategoryViewHolder(private val binding: CategoryItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: String, onClickAction: (String) -> Unit) {
        item.apply {
            with(binding) {
                categoryName.text = item
                categoryNext.setOnClickListener { onClickAction(item) }
            }
        }
    }
}