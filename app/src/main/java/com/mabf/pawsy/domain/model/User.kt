package com.mabf.pawsy.domain.model

data class User (
    val id: String,
    val name: String,
    val age: Int,
    val email: String,
    val phone: String,
    val dni: String,
    val residenceArea: String,
    val photoUrl: String
)