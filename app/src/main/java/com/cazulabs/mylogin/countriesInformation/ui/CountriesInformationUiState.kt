package com.cazulabs.mylogin.countriesInformation.ui

import com.cazulabs.mylogin.countriesInformation.data.model.CountryInformationModel

sealed interface CountriesInformationUiState {
    data object Loading: CountriesInformationUiState
    data class Error(val throwable: Throwable): CountriesInformationUiState
    data class Success(val tasks:List<CountryInformationModel>): CountriesInformationUiState
}