package com.mabf.pawsy.domain.model

data class CreateAdoptionRequest(
    val fullName: String,
    val phone: String,
    val city: String,
    val housingType: String,
    val hasOtherPets: Boolean,
    val experience: String,
    val reason: String,
    val animalId: String
)