package com.cazulabs.mylogin.countriesInformation.domain

import com.cazulabs.mylogin.countriesInformation.data.CountriesInformationRepository
import com.cazulabs.mylogin.countriesInformation.data.network.response.CountryInformationResponse
import javax.inject.Inject

class GetCountriesInformationUseCase @Inject constructor(private val repository: CountriesInformationRepository) {

    suspend operator fun invoke(): List<CountryInformationResponse> {
        return repository.getCountriesInformation()
    }

}