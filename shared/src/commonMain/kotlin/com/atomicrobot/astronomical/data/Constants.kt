package com.atomicrobot.astronomical.data

import io.ktor.http.Url

object Constants {
    const val baseApi = "https://api.nasa.gov/planetary/apod"
    const val apiParam = "api_key"
    const val countParam = "count"
    const val defaultCount = 10
    const val dateParam = "date"
}