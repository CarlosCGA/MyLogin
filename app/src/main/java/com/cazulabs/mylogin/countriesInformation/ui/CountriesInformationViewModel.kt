package com.cazulabs.mylogin.countriesInformation.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cazulabs.mylogin.countriesInformation.domain.GetCountriesInformationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountriesInformationViewModel @Inject constructor(private val countriesInformationUseCase: GetCountriesInformationUseCase) :
    ViewModel() {

        fun getCountriesInformation() {
            viewModelScope.launch {
                val response = countriesInformationUseCase()

                Log.i("CARLOS", "RESPONSE SIZE -> ${response.size}")
                Log.i("CARLOS", "$response")
            }
        }

}