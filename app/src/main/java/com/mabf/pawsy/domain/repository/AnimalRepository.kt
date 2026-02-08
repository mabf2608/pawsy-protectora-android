package com.mabf.pawsy.domain.repository
import com.mabf.pawsy.domain.model.Animal

interface AnimalRepository {
    suspend fun getAnimals(): List<Animal>
    suspend fun getAnimalById(id: String): Animal
}