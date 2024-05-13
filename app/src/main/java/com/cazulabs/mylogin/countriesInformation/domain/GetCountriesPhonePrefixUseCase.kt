package com.cazulabs.mylogin.countriesInformation.domain

import com.cazulabs.mylogin.countriesInformation.data.CountriesInformationRepository
import com.cazulabs.mylogin.countriesInformation.data.model.CountryPhonePrefixModel
import javax.inject.Inject

class GetCountriesPhonePrefixUseCase @Inject constructor(private val repository: CountriesInformationRepository) {

    suspend operator fun invoke(): List<CountryPhonePrefixModel> {
        return repository.getCountriesPhoneCode()
    }

}