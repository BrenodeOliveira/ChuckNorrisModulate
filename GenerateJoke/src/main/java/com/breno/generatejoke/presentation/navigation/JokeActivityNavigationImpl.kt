package com.breno.generatejoke.presentation.navigation

import android.content.Context
import android.content.Intent
import com.breno.generatejoke.presentation.JokeActivity
import com.breno.navigation.JokeActivityNavigation

internal class JokeActivityNavigationImpl: JokeActivityNavigation {

    override fun newIntent(context: Context, jokeCategory: String) {
        val intent = Intent(context, JokeActivity::class.java)
        intent.putExtra("category", jokeCategory)
        context.startActivity(intent)
    }
}