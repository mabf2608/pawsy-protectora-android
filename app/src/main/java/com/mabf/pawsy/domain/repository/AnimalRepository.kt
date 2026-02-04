package com.mabf.pawsy.domain.repository

interface AnimalRepository {
    fun getAnimals(): List<String>
}