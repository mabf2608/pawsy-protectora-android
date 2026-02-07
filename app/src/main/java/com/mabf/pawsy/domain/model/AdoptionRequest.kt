package com.mabf.pawsy.domain.model

/**
 * Regla de negocio importante:
 * - Un usuario solo puede enviar UNA solicitud de adopción por animal.
 *
 * Esta restricción UNIQUE(user, animal) NO está forzada por el esquema de Strapi,
 * por lo que debe controlarse mediante lógica de backend y/o validación en el cliente.
 */

data class AdoptionRequest(
    val id: String,
    val fullName: String,
    val phone: String,
    val city: String,
    val housingType: String,
    val hasOtherPets: Boolean,
    val experience: String,
    val reason: String,
    val status: AdoptionRequestStatus,
    val adminNotes: String?,
    val animalId: String,
    val userId: String
)