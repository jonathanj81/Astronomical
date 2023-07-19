package com.atomicrobot.astronomical.di

import com.atomicrobot.astronomical.NasaViewModel
import com.atomicrobot.astronomical.data.Database
import com.atomicrobot.astronomical.data.DatabaseDriverFactory
import com.atomicrobot.astronomical.data.NasaApi
import com.atomicrobot.astronomical.data.NasaRepository
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

    single { NasaApi() }

    single{ Database(databaseDriverFactory) }

    single{ NasaRepository(get(), get())}

    single{ NasaViewModel(get())}
}