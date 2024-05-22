package com.cazulabs.mylogin.countriesInformation.domain

import com.cazulabs.mylogin.countriesInformation.data.CountriesInformationRepository
import javax.inject.Inject

class GetAndInsertUseCase @Inject constructor(private val repository: CountriesInformationRepository) {

    suspend operator fun invoke() {
        repository.getAndInsertInLocal()
    }

}