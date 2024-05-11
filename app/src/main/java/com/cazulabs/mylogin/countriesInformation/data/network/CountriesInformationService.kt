package com.cazulabs.mylogin.countriesInformation.data.network

import com.cazulabs.mylogin.countriesInformation.data.network.response.CountryInformationResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CountriesInformationService @Inject constructor(private val countriesInformationClient: CountriesInformationClient) {

    suspend fun getCountriesInformation(): List<CountryInformationResponse> {
        return withContext(Dispatchers.IO) {
            val response = countriesInformationClient.getCountriesInformation()
            response.body() ?: emptyList()
        }
    }

}