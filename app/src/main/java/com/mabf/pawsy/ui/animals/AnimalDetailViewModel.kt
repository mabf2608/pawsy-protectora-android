package com.mabf.pawsy.ui.animals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mabf.pawsy.domain.model.Animal
import com.mabf.pawsy.domain.repository.AnimalRepository
import com.mabf.pawsy.ui.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimalDetailViewModel @Inject constructor(
    private val animalRepository: AnimalRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<Animal>>(UiState.Loading)
    val uiState: StateFlow<UiState<Animal>> = _uiState.asStateFlow()

    fun loadAnimal(animalId: String) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val animal = animalRepository.getAnimalById(animalId)
                _uiState.value = UiState.Success(animal)
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message ?: "Error desconocido")
            }
        }
    }
}