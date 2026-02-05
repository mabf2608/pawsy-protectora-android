package com.mabf.pawsy.domain.model

data class Animal (
    val id: String,
    val name: String,
    val age: Int,
    val species: AnimalSpecies,
    val adoptionStatus: AdoptionStatus,
    val description: String,
    val photoUrl: String
)