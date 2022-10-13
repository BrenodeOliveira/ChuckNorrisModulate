package com.breno.navigation

import android.content.Context

interface JokeActivityNavigation {

    fun newIntent(
        context: Context,
        jokeCategory: String
    )
}