package com.breno.chuckmodularizate.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.breno.chuckmodularizate.databinding.ActivityMainBinding
import com.breno.chuckmodularizate.presentation.adapter.CategoryAdapter
import com.breno.chuckmodularizate.presentation.viewmodel.MainViewModel
import com.breno.navigation.JokeActivityNavigation
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: MainViewModel by viewModel()
    private val adapterCategory: CategoryAdapter = fetchAdapter()
    private val jokeActivityNavigation: JokeActivityNavigation by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupObservers()
        viewModel.fetchCategories()

        binding.rvCategories.adapter = adapterCategory
    }

    private fun setupObservers() {
        with(viewModel) {
            categories.observe(this@MainActivity) {
                adapterCategory.submitList(it)
            }
            loadingState.observe(this@MainActivity) { state ->
                setupScreenContent(state)
            }
        }
    }

    private fun setupScreenContent(state: Boolean) {
        with(binding) {
            if (state) {
                rvCategories.isVisible = !state
                shimmerLayout.isVisible = state
            } else {
                rvCategories.isVisible = !state
                shimmerLayout.isVisible = state
            }
        }
    }

    private fun fetchAdapter() = CategoryAdapter(::itemClicked)

    private fun itemClicked(category: String) {
        jokeActivityNavigation.newIntent(this, category)
    }
}