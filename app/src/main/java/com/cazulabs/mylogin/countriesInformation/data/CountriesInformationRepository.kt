package com.cazulabs.mylogin.countriesInformation.data

import com.cazulabs.mylogin.countriesInformation.data.network.CountriesInformationService
import com.cazulabs.mylogin.countriesInformation.data.network.response.CountryInformationResponse
import javax.inject.Inject

class CountriesInformationRepository @Inject constructor(private val api: CountriesInformationService) {

    suspend fun getCountriesInformation(): List<CountryInformationResponse> {
        return api.getCountriesInformation()
    }

}