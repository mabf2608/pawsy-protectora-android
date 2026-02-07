package com.mabf.pawsy.domain.model

data class CreateDonation(
    val amount: Double,
    val message: String?,
    val animalId: String
)