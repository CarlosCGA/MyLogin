package com.cazulabs.mylogin.countriesInformation.data.network

import com.cazulabs.mylogin.countriesInformation.data.network.response.CountriesInformationResponse
import retrofit2.Response
import retrofit2.http.GET

interface CountriesInformationClient {

    @GET("v3/f763e56b-6a5b-4f6d-81c7-c7e30f6f618f")
    suspend fun getCountriesInformation(): Response<CountriesInformationResponse>
}