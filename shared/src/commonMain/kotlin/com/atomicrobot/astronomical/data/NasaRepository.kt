package com.atomicrobot.astronomical.data

import org.koin.core.component.KoinComponent

class NasaRepository (
    private val database: Database,
    private val api: NasaApi
): KoinComponent {

    @Throws(Exception::class)
    suspend fun retrieveRandomStartingImages(count: Int): List<SpacePic> {
        val cachedImages = database.retrieveAllImages()
        return if (cachedImages.isNullOrEmpty()){
            val apiImages = api.getRandomStartingImages(count)
            database.insertMultipleImages(apiImages)
            apiImages
        } else {
            cachedImages
        }
    }

    @Throws(Exception::class)
    suspend fun retrieveSingleRandomImage(): SpacePic {
        val apiImage = api.getRandomStartingImages(1).first()
        database.insertImage(apiImage)

        return apiImage
    }

    @Throws(Exception::class)
    suspend fun retrieveImageForSpecificDay(standardDate: String): SpacePic {
        val cachedImage = database.retrieveSingleImage(standardDate)
        return if (cachedImage == null) {
            val apiImage = api.getImageForSpecificDate(standardDate)
            database.insertImage(apiImage)
            apiImage
        } else {
            cachedImage
        }
    }
}