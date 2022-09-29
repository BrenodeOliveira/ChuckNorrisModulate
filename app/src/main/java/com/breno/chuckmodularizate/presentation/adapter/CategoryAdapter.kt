package com.breno.chuckmodularizate.presentation.adapter

import android.view.LayoutInflater.from
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.breno.chuckmodularizate.databinding.CategoryItemBinding

internal class CategoryAdapter(private val onItemClicked: (String) -> Unit) :
    ListAdapter<String, CategoryViewHolder>(DefaultDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = CategoryItemBinding.inflate(from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(currentList[position], ::onCategoryClicked)
    }

    private fun onCategoryClicked(category: String) {
        onItemClicked.invoke(category)
    }
}