package com.atomicrobot.astronomical.data

class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal fun insertImage(imageItem: SpacePic) {
        dbQuery.insertImage(
            date = imageItem.date,
            explanation = imageItem.explanation,
            title = imageItem.title,
            url = imageItem.url
        )
    }

    internal fun insertMultipleImages(images: List<SpacePic>) {
        dbQuery.transaction {
            images.forEach {
                insertImage(it)
            }
        }
    }

    internal fun retrieveAllImages(): List<SpacePic>? {
        return try {
            dbQuery.retrieveAllImages().executeAsList().map {
                it.toSpacePic()
            }
        } catch (e: Exception) {
            null
        }
    }

    internal fun retrieveSingleImage(date: String): SpacePic? {
        return try {
            dbQuery.retrieveSingleImage(date = date).executeAsOne().toSpacePic()
        } catch (e: Exception) {
            null
        }
    }

    private fun Image.toSpacePic(): SpacePic = SpacePic(
        date = date,
        explanation = explanation,
        title = title,
        url = url
    )
}