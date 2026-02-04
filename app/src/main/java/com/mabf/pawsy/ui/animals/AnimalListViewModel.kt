package com.mabf.pawsy.ui.animals

import androidx.lifecycle.ViewModel
import com.mabf.pawsy.domain.repository.AnimalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimalListViewModel @Inject constructor(
    private val animalRepository: AnimalRepository
) : ViewModel() {

    fun loadAnimals(): List<String> {
        return animalRepository.getAnimals()
    }
}