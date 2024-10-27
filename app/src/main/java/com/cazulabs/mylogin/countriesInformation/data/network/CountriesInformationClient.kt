package com.cazulabs.mylogin.countriesInformation.data.network

import com.cazulabs.mylogin.core.network.Endpoints
import com.cazulabs.mylogin.countriesInformation.data.network.response.CountryInformationResponse
import retrofit2.Response
import retrofit2.http.GET

interface CountriesInformationClient {

    @GET(Endpoints.GET_COUNTRIES_INFORMATION)
    suspend fun getCountriesInformation(): Response<List<CountryInformationResponse>>
}