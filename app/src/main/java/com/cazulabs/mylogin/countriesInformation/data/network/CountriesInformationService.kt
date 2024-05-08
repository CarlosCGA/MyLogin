package com.cazulabs.mylogin.countriesInformation.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CountriesInformationService @Inject constructor(private val countriesInformationClient: CountriesInformationClient) {

    suspend fun getCountriesInformation(): List<Any> {
        return withContext(Dispatchers.IO) {
            val response = countriesInformationClient.getCountriesInformation()
            response.body()?.countries ?: emptyList()
        }
    }

}