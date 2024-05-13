package com.cazulabs.mylogin.countriesInformation.data

import com.cazulabs.mylogin.countriesInformation.data.model.CountryInformationModel
import com.cazulabs.mylogin.countriesInformation.data.network.CountriesInformationService
import javax.inject.Inject

class CountriesInformationRepository @Inject constructor(private val api: CountriesInformationService) {

    suspend fun getCountriesInformation(): List<CountryInformationModel> {
        return api.getCountriesInformation().map { countryResponse ->
            CountryInformationModel(
                name = countryResponse.name,
                countryCode = countryResponse.countryCode,
                emoji = countryResponse.emoji,
                unicode = countryResponse.unicode,
                dialCode = countryResponse.dialCode,
                imageURL = countryResponse.imageURL
            )
        }
    }

}