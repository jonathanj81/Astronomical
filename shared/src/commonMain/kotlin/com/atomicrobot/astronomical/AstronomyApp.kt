package com.atomicrobot.astronomical

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AstronomyApp: KoinComponent {

    private val nasaViewModel: NasaViewModel by inject()

    @Composable fun mainContent() {

        val imageState by nasaViewModel.imageState.collectAsState()

        return MaterialTheme {

            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

                Text(imageState.number.toString())

                Button(onClick = nasaViewModel::newNumber) {
                    Text("Get new number")
                }
            }
        }
    }
}