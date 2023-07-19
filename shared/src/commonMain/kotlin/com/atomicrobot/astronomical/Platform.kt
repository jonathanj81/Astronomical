package com.atomicrobot.astronomical

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform