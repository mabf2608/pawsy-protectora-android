package com.mabf.pawsy.data.repository

import com.mabf.pawsy.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor() : AuthRepository {
    override fun isLoggedIn(): Boolean {
        // Día 2: esqueleto. Luego vendrá DataStore/Firebase/etc.
        return false
    }
}