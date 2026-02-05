package com.mabf.pawsy.ui.animals

import androidx.lifecycle.viewModelScope
import com.mabf.pawsy.domain.model.Animal
import com.mabf.pawsy.domain.repository.AnimalRepository
import com.mabf.pawsy.ui.common.BaseViewModel
import com.mabf.pawsy.ui.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class AnimalListViewModel @Inject constructor (private val animalRepository: AnimalRepository) : BaseViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<Animal>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<Animal>>> = _uiState.asStateFlow()

    init {
        loadAnimals()
    }

    fun loadAnimals() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val animals = animalRepository.getAnimals()
                _uiState.value = UiState.Success(animals)
            } catch (e: Exception) {
                _uiState.value = UiState.Error(message = throwableToMessage(e), cause = e)
            }
        }
    }

}