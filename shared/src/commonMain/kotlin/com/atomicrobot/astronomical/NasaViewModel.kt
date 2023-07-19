package com.atomicrobot.astronomical

import com.atomicrobot.astronomical.data.NasaRepository
import com.atomicrobot.astronomical.data.SpacePic
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import kotlin.random.Random

class NasaViewModel(
    private val nasaRepository: NasaRepository
): ViewModel(), KoinComponent {

    private val _imageState = MutableStateFlow(State())

    val imageState: StateFlow<State> = _imageState.asStateFlow()

    fun newNumber() {
        _imageState.update {
            it.copy(
                number = Random.nextInt(0,100)
            )
        }
    }
//
//    init {
//        viewModelScope.launch {
//            val image = nasaRepository.retrieveRandomStartingImages(5).first()
//
//            _imageState.update {
//                it.copy(
//                    currentImage = image
//                )
//            }
//        }
//    }
//
//    fun getNewImage() {
//        viewModelScope.launch {
//            val image = nasaRepository.retrieveRandomStartingImages(5).first()
//
//            _imageState.update {
//                it.copy(
//                    currentImage = image
//                )
//            }
//        }
//    }
//
    data class State(
        val number: Int = Random.nextInt(0,100)
    )
}