package com.breno.generatejoke.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.breno.generatejoke.databinding.ActivityJokeBinding

internal const val KEY_EXTRA = "category"

class JokeActivity : AppCompatActivity() {

    private val binding: ActivityJokeBinding by lazy { ActivityJokeBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val extra = intent.getStringExtra(KEY_EXTRA)

        binding.tvJokeGenerated.text = extra.toString()
    }
}