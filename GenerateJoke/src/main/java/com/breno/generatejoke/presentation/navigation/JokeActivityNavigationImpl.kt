package com.breno.generatejoke.presentation.navigation

import android.content.Context
import com.breno.generatejoke.presentation.JokeActivity
import com.breno.navigation.JokeActivityNavigation

internal class JokeActivityNavigationImpl: JokeActivityNavigation {

    override fun newIntent(context: Context, jokeCategory: String) {
        JokeActivity.newIntent(context, jokeCategory)
    }
}