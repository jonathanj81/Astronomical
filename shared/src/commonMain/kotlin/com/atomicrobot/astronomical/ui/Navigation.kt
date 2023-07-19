package com.atomicrobot.astronomical.ui

sealed class Screens(val route: String) {
    object Overview: Screens(route = "overview")
    object Details: Screens(route = "details")
}