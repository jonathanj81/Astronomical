package com.atomicrobot.astronomical.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.atomicrobot.astronomical.data.SpacePic
import com.seiko.imageloader.rememberAsyncImagePainter

@Composable
fun DetailsScreen(
    spacePic: SpacePic?,
    onNavigateBack: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        IconButton(
            onClick = onNavigateBack
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "back"
            )
        }

        Image(
            modifier = Modifier.fillMaxWidth(0.75f).aspectRatio(1f),
            contentScale = ContentScale.FillBounds,
            painter = rememberAsyncImagePainter(spacePic?.url ?: ""),
            contentDescription = "")

        spacePic?.explanation?.let {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = it
            )
        }
    }
}