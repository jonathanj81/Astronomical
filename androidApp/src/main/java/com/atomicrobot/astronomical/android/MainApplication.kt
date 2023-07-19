package com.atomicrobot.astronomical.android

import android.app.Application
import com.atomicrobot.astronomical.data.DatabaseDriverFactory
import com.atomicrobot.astronomical.di.initKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin(DatabaseDriverFactory(this@MainApplication))
    }
}