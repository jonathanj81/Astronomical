package com.atomicrobot.astronomical.data

import com.atomicrobot.astronomical.BuildKonfig
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.headers
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.component.KoinComponent

class NasaApi(): KoinComponent {

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    suspend fun getImageForSpecificDate(standardDate: String): SpacePic {
        return client.get {
            url(Constants.baseApi)
            parameter(Constants.apiParam, BuildKonfig.nasa)
            parameter(Constants.dateParam, standardDate)
        }.body<SpacePic>()
    }

    suspend fun getRandomStartingImages(count: Int): List<SpacePic> {
        return client.get{
            url(Constants.baseApi)
            parameter(Constants.apiParam, BuildKonfig.nasa)
            parameter(Constants.countParam, count)
            headers {
                append(HttpHeaders.ContentType, "application/json")
            }
        }.body<List<SpacePic>>()
    }
}