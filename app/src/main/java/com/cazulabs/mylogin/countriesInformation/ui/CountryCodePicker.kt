package com.cazulabs.mylogin.countriesInformation.ui

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CountryCodePicker(countriesInformationViewModel: CountriesInformationViewModel = hiltViewModel<CountriesInformationViewModel>()) {
    Text(
        modifier = Modifier.clickable { countriesInformationViewModel.getCountriesInformation() },
        text = "CLICK ME"
    )
}