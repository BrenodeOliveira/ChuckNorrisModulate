package com.breno.generatejoke.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.breno.generatejoke.databinding.ActivityJokeBinding
import com.breno.generatejoke.presentation.viewmodel.JokeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

internal const val KEY_EXTRA = "category"

class JokeActivity : AppCompatActivity() {

    private val binding: ActivityJokeBinding by lazy { ActivityJokeBinding.inflate(layoutInflater) }
    private val viewModel: JokeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val extra = intent.getStringExtra(KEY_EXTRA).orEmpty()

        setupClick(extra)
        setupObserver()
    }

    private fun setupClick(category: String) {
        binding.btnGenerateJoke.setOnClickListener {
            viewModel.generateJoke(category)
        }
    }

    private fun setupObserver() {
        viewModel.categories.observe(this) {
            binding.tvJokeGenerated.text = it
        }
    }


    companion object {
        fun newIntent(context: Context, jokeCategory: String) {
            val intent = Intent(context, JokeActivity::class.java)
            intent.putExtra("category", jokeCategory)
            context.startActivity(intent)
        }
    }
}