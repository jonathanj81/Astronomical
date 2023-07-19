package com.atomicrobot.astronomical.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpacePic(
    @SerialName("date")
    val date: String,
    @SerialName("explanation")
    val explanation: String?,
    @SerialName("title")
    val title: String?,
    @SerialName("url")
    val url: String?
)