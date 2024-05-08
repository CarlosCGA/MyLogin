package com.cazulabs.mylogin.countriesInformation.data

import com.cazulabs.mylogin.countriesInformation.data.network.CountriesInformationService
import javax.inject.Inject

class CountriesInformationRepository @Inject constructor(private val api: CountriesInformationService) {

    suspend fun getCountriesInformation(): List<Any> {
        return api.getCountriesInformation()
    }

}