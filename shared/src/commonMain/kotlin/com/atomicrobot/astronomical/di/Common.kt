package com.atomicrobot.astronomical.di

import com.atomicrobot.astronomical.data.DatabaseDriverFactory
import com.atomicrobot.astronomical.data.NasaApi
import com.atomicrobot.astronomical.data.NasaRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(databaseDriverFactory: DatabaseDriverFactory, appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(commonModule(databaseDriverFactory))
    }

fun initKoin(databaseDriverFactory: DatabaseDriverFactory) = initKoin(databaseDriverFactory = databaseDriverFactory) {}

fun commonModule(databaseDriverFactory: DatabaseDriverFactory) = module {
    single{ HttpClient{
        install(ContentNegotiation){
            Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            }
        }
    } }

    single { NasaApi(get()) }

    single{ databaseDriverFactory.createDriver() }

    single{ NasaRepository(get(), get())}
}