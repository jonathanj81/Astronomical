package com.atomicrobot.astronomical

import com.atomicrobot.astronomical.data.NasaRepository
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import org.koin.core.component.KoinComponent
import kotlin.random.Random

class NasaViewModel(
    private val nasaRepository: NasaRepository
): ViewModel(), KoinComponent {

    val number = Random.nextInt(0,100)
}