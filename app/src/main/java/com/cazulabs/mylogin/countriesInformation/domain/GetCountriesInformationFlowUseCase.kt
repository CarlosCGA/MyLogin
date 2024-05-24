package com.cazulabs.mylogin.countriesInformation.domain

import com.cazulabs.mylogin.countriesInformation.data.CountriesInformationRepository
import com.cazulabs.mylogin.countriesInformation.data.model.CountryInformationModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCountriesInformationFlowUseCase @Inject constructor(private val repository: CountriesInformationRepository) {

    operator fun invoke(): Flow<List<CountryInformationModel>> = repository.countriesInformation

}