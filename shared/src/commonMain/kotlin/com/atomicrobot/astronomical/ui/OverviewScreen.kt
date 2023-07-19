package com.atomicrobot.astronomical.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.atomicrobot.astronomical.data.SpacePic
import com.seiko.imageloader.rememberAsyncImagePainter

@Composable
fun OverviewScreen(
    spacePic: SpacePic?,
    onNavigateToDetails: () -> Unit,
    onGetNewImage: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        when (spacePic?.url){
            null -> CircularProgressIndicator()
            else -> Image(
                modifier = Modifier.fillMaxWidth().aspectRatio(1f),
                contentScale = ContentScale.FillBounds,
                painter = rememberAsyncImagePainter(spacePic.url ?: ""),
                contentDescription = "")
        }

        Button(onClick = onNavigateToDetails) {
            Text("Get details")
        }

        Button(onClick = onGetNewImage) {
            Text("Get new image")
        }
    }
}