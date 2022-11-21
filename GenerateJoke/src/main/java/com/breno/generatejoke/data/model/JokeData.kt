package com.breno.generatejoke.data.model

import com.google.gson.annotations.SerializedName

data class JokeData(
    @SerializedName("icon_url") val icon_url: String? = null,
    @SerializedName("id") val id: String? = null,
    @SerializedName("url") val url: String? = null,
    @SerializedName("value") val value: String? = null,
)