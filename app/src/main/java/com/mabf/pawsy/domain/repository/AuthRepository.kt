package com.mabf.pawsy.domain.repository

interface AuthRepository {
    fun isLoggedIn(): Boolean

    // Día 4: fake en memoria (más adelante será Strapi + DataStore)
    fun logIn()
    fun logOut()
}