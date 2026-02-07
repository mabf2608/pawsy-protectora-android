package com.mabf.pawsy.data.repository

import com.mabf.pawsy.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor() : AuthRepository {
    // Día 4: estado en memoria (no persiste al cerrar la app)
    private var loggedIn: Boolean = false

    override fun isLoggedIn(): Boolean = loggedIn

    override fun logIn() {
        loggedIn = true
    }

    override fun logOut() {
        loggedIn = false
    }
}