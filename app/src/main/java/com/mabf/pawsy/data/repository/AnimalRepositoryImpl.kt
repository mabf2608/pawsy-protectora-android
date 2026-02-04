package com.mabf.pawsy.data.repository

import com.mabf.pawsy.domain.repository.AnimalRepository
import javax.inject.Inject

class AnimalRepositoryImpl @Inject constructor() : AnimalRepository {
    override fun getAnimals(): List<String> {
        // Día 2: esqueleto. Luego conectará con remote/local.
        return emptyList()
    }
}