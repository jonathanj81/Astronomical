package com.atomicrobot.astronomical.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.atomicrobot.astronomical.NasaViewModel
import com.seiko.imageloader.rememberAsyncImagePainter
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AstronomyApp: KoinComponent {

    private val nasaViewModel: NasaViewModel by inject()

    @Composable fun mainContent() {

        val imageState by nasaViewModel.imageState.collectAsState()

        return MaterialTheme {

            when(imageState.screen){
                Screens.Overview -> OverviewScreen(
                    spacePic = imageState.currentImage,
                    onGetNewImage = nasaViewModel::getNewImage,
                    onNavigateToDetails = nasaViewModel::goToDetails
                )
                Screens.Details -> DetailsScreen(
                    spacePic = imageState.currentImage,
                    onNavigateBack = nasaViewModel::goBack
                )
            }
        }
    }
}