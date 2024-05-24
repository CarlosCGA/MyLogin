package com.cazulabs.mylogin.countriesInformation.ui

import com.cazulabs.mylogin.countriesInformation.data.model.CountryPhonePrefixModel

sealed interface CountriesPhonePrefixUiState {
    data object Loading : CountriesPhonePrefixUiState
    data class Error(val throwable: Throwable) : CountriesPhonePrefixUiState
    data class Success(val countriesPhonePrefix: List<CountryPhonePrefixModel>) :
        CountriesPhonePrefixUiState
}