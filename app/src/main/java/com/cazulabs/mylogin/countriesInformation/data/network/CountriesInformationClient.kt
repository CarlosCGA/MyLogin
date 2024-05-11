package com.cazulabs.mylogin.countriesInformation.data.network

import com.cazulabs.mylogin.countriesInformation.data.network.response.CountryInformationResponse
import retrofit2.Response
import retrofit2.http.GET

interface CountriesInformationClient {

    @GET("v3/9bfa16f4-b86d-4cee-b324-5479a093d0d9")
    suspend fun getCountriesInformation(): Response<List<CountryInformationResponse>>
}