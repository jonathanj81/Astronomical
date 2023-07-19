package com.atomicrobot.astronomical

import androidx.compose.ui.window.ComposeUIViewController
import com.atomicrobot.astronomical.ui.AstronomyApp

fun MainViewController() = ComposeUIViewController { AstronomyApp().mainContent() }