package com.cazulabs.mylogin.core.ui.components.textFields

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.cazulabs.mylogin.countriesInformation.data.model.CountryPhonePrefixModel
import com.cazulabs.mylogin.countriesInformation.ui.CountriesPhonePrefixUiState
import com.cazulabs.mylogin.signIn.ui.SignInViewModel

@Composable
fun PhoneWithPrefix(
    modifier: Modifier = Modifier,
    phonePrefix: String = "",
    onPhonePrefixChange: (String) -> Unit,
    uiState: CountriesPhonePrefixUiState,
    phone: String,
    onValueChange: (String) -> Unit,
    signInViewModel: SignInViewModel
) {
    OutlinedTextField(
        modifier = modifier,
        value = phone,
        onValueChange = { newPhone ->
            onValueChange(newPhone)
        },
        singleLine = true,
        prefix = {
            when (uiState) {
                is CountriesPhonePrefixUiState.Error -> {
                }

                CountriesPhonePrefixUiState.Loading -> {
                    CircularProgressIndicator()
                }

                is CountriesPhonePrefixUiState.Success -> {
                    if (uiState.countriesPhonePrefix.isNotEmpty()) {
                        PhonePrefixDropDown(
                            phonePrefix = phonePrefix,
                            onPhonePrefixChange = onPhonePrefixChange,
                            countriesPhonePrefix = uiState.countriesPhonePrefix,
                        )
                    } else
                        signInViewModel.insertCountriesInformation()
                }
            }

        },
        label = { Text(text = "Phone") },
        leadingIcon = {
            Icon(imageVector = Icons.Outlined.Phone, contentDescription = "phone")
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
    )
}

@Composable
fun PhonePrefixDropDown(
    countriesPhonePrefix: List<CountryPhonePrefixModel>,
    phonePrefix: String,
    onPhonePrefixChange: (String) -> Unit,
) {
    var isExpanded by rememberSaveable {
        mutableStateOf(false)
    }

    var itemSelected by rememberSaveable {
        mutableStateOf(phonePrefix)
    }

    Text(modifier = Modifier.clickable { isExpanded = true }, text = itemSelected)

    DropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
        countriesPhonePrefix.map { country ->
            if (country.dialCode.isNotEmpty()) {
                DropdownMenuItem(
                    text = {
                        MenuItem(country = country)
                    },
                    onClick = {
                        itemSelected = country.dialCode
                        onPhonePrefixChange(country.dialCode)
                        isExpanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun MenuItem(country: CountryPhonePrefixModel) {
    Row {
        Text(text = country.emoji)
        Spacer(modifier = Modifier.size(4.dp))
        Text(text = country.name)
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = country.dialCode, fontWeight = FontWeight.Bold)
    }
}

/*
@Preview(showBackground = true)
@Composable
fun PhoneWithPrefixPreview() {
    val countries = listOf(
        CountryPhonePrefixModel("France", "FR", "+43"),
        CountryPhonePrefixModel("Spain", "ES", "+34"),
        CountryPhonePrefixModel("Italy", "IT", "+22"),
        CountryPhonePrefixModel("Great Britain", "Gb", "+2"),
        CountryPhonePrefixModel("Germany", "GR", "+48"),
    )
    PhoneWithPrefix(phonePrefix = "34", onPhonePrefixChange = {},  countriesPhonePrefix = countries, phone = "") {

    }
}
*/