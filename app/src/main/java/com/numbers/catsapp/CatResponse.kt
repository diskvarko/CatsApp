package com.numbers.catsapp

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*


@Serializable
data class CatResponse(
        @SerialName("id")
        val id: String,
        @SerialName("url")
        val imageUrl: String,
        @SerialName("width")
        val width: Long,
        @SerialName("height")
        val height: Long
)
