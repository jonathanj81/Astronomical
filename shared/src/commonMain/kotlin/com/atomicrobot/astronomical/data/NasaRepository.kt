package com.atomicrobot.astronomical.data

class NasaRepository (databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory)
    private val api = NasaApi()

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