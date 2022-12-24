package com.breno.generatejoke.data.model

import com.breno.generatejoke.domain.model.JokeModel
import com.google.gson.annotations.SerializedName

data class JokeData(
    @SerializedName("icon_url") val icon_url: String? = null,
    @SerializedName("id") val id: String? = null,
    @SerializedName("url") val url: String? = null,
    @SerializedName("value") val value: String? = null,
)

fun JokeData.toModel(): JokeModel {
    return JokeModel(
        icon_url = this.icon_url.orEmpty(),
        id = this.id.orEmpty(),
        url = this.url.orEmpty(),
        value = this.value.orEmpty(),
    )
}