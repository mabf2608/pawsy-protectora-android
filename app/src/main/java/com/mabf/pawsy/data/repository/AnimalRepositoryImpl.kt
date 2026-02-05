package com.mabf.pawsy.data.repository

import com.mabf.pawsy.domain.model.Animal
import com.mabf.pawsy.domain.repository.AnimalRepository
import javax.inject.Inject
import kotlinx.coroutines.delay

class AnimalRepositoryImpl @Inject constructor() : AnimalRepository {
    override suspend fun getAnimals(): List<Animal> {
        delay(800)
        return emptyList()
    }
}