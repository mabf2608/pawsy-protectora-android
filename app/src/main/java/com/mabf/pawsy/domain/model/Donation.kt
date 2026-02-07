package com.mabf.pawsy.domain.model

data class Donation(
    val id: String,
    val amount: Double,
    val message: String?,
    val animalId: String,
    val userId: String,
    val createdAt: String
)