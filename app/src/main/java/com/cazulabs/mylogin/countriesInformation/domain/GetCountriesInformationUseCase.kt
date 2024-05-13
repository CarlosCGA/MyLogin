package com.cazulabs.mylogin.countriesInformation.domain

import com.cazulabs.mylogin.countriesInformation.data.CountriesInformationRepository
import com.cazulabs.mylogin.countriesInformation.data.model.CountryInformationModel
import javax.inject.Inject

class GetCountriesInformationUseCase @Inject constructor(private val repository: CountriesInformationRepository) {

    suspend operator fun invoke(): List<CountryInformationModel> {
        return repository.getCountriesInformation()
    }

}