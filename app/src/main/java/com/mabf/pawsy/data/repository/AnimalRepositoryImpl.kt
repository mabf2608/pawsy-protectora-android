package com.mabf.pawsy.data.repository

import com.mabf.pawsy.domain.model.Animal
import com.mabf.pawsy.domain.model.AnimalSpecies
import com.mabf.pawsy.domain.model.AdoptionStatus
import com.mabf.pawsy.domain.repository.AnimalRepository
import javax.inject.Inject

class AnimalRepositoryImpl @Inject constructor() : AnimalRepository {
    override suspend fun getAnimals(): List<Animal> {

        return listOf(
            Animal(
                id = "1",
                name = "Dobby",
                estimatedAge = 6,
                species = AnimalSpecies.DOG,
                adoptionStatus = AdoptionStatus.SPONSORED,
                description = "Es un perro de casa",
                photoUrl = "https://res.cloudinary.com/dldw1cucs/image/upload/v1770390680/Logo_Pawsy_b3a80ac212.png"
            ),
            Animal(
                id = "2",
                name = "Kiki",
                estimatedAge = 2,
                species = AnimalSpecies.CAT,
                adoptionStatus = AdoptionStatus.AVAILABLE,
                description = "Gata tranquila y cariñosa. Se adapta bien a piso.",
                photoUrl = "https://res.cloudinary.com/dldw1cucs/image/upload/v1770390681/small_Logo_Pawsy_b3a80ac212.png"
            ),
            Animal(
                id = "3",
                name = "Lala",
                estimatedAge = 2,
                species = AnimalSpecies.CAT,
                adoptionStatus = AdoptionStatus.AVAILABLE,
                description = "Gata curiosa, algo tímida al principio.",
                photoUrl = "https://res.cloudinary.com/dldw1cucs/image/upload/v1770390681/medium_Logo_Pawsy_b3a80ac212.png"
            ),
            Animal(
                id = "4",
                name = "Nube",
                estimatedAge = 1,
                species = AnimalSpecies.RABBIT,
                adoptionStatus = AdoptionStatus.ADOPTED,
                description = "Conejo joven, necesita espacio y enriquecimiento.",
                photoUrl = "https://res.cloudinary.com/dldw1cucs/image/upload/v1770390680/thumbnail_Logo_Pawsy_b3a80ac212.png"
            )
        )

    }
}