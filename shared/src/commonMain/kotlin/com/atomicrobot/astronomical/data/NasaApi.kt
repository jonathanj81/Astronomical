package com.atomicrobot.astronomical.data

import com.atomicrobot.astronomical.BuildKonfig
import com.atomicrobot.astronomical.data.Constants
import com.atomicrobot.astronomical.data.SpacePic
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class NasaApi {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    suspend fun getImageForSpecificDate(standardDate: String): SpacePic {
        return httpClient.get {
            url(Constants.baseApi)
            parameter(Constants.apiParam, BuildKonfig.nasa)
            parameter(Constants.dateParam, standardDate)
        }.body()
    }

    suspend fun getRandomStartingImages(count: Int): List<SpacePic> {
        return httpClient.get{
            url(Constants.baseApi)
            parameter(Constants.apiParam, BuildKonfig.nasa)
            parameter(Constants.countParam, count)
        }.body()
    }
}