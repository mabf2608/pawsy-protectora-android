package com.mabf.pawsy.domain.repository

interface AuthRepository {
    fun isLoggedIn(): Boolean
}