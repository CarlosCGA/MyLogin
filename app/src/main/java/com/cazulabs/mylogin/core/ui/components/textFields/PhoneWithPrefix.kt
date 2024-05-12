package com.cazulabs.mylogin.core.ui.components.textFields

import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Phone
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.cazulabs.mylogin.countriesInformation.data.network.response.CountryInformationResponse

@Composable
fun PhoneWithPrefix(
    phonePrefix: String = "",
    onPhonePrefixChange: (String) -> Unit = {},
    onClickPhonePrefix: () -> Unit = {},
    countries: List<CountryInformationResponse>,
    phone: String,
    onValueChange: (String) -> Unit
) {
    var expandedPrefixSelector by rememberSaveable {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier,
        value = phone,
        onValueChange = { newPhone ->
            onValueChange(newPhone)
        },
        singleLine = true,
        prefix = {
            if (phonePrefix.isNotEmpty())
                PhonePrefixDropDown(
                    expanded = expandedPrefixSelector,
                    phonePrefix = phonePrefix,
                    countries = countries,
                    onClickPhonePrefix = onClickPhonePrefix
                )
            //PhonePrefix(phonePrefix = phonePrefix, onClickPhonePrefix = onClickPhonePrefix)
        },
        label = { Text(text = "Phone") },
        leadingIcon = {
            Icon(imageVector = Icons.Outlined.Phone, contentDescription = "phone")
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
    )
}

@Composable
fun PhonePrefix(phonePrefix: String, onClickPhonePrefix: () -> Unit) {
    Text(modifier = Modifier.clickable {
        onClickPhonePrefix()
    }, text = "+$phonePrefix", color = Color.Gray)
}

@Composable
fun PhonePrefixDropDown(
    expanded: Boolean,
    countries: List<CountryInformationResponse>,
    phonePrefix: String,
    onClickPhonePrefix: () -> Unit
) {
    var itemSelected by rememberSaveable {
        mutableStateOf("")
    }

    DropdownMenu(expanded = expanded, onDismissRequest = { /*TODO ON_DISMISS*/ }) {
        countries.map { country ->
            DropdownMenuItem(
                text = { Text(text = country.name) },
                onClick = {
                    itemSelected = country.name
                    //expanded = false
                },
                /*
                colors = MenuItemColors(
                    textColor = Color.Red,
                    leadingIconColor = Color.Yellow,
                    trailingIconColor = Color.Green,
                    disabledLeadingIconColor = Color.DarkGray,
                    disabledTextColor = Color.Black,
                    disabledTrailingIconColor = Color.Blue
                )
                */
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PhoneWithPrefixPreview() {
    PhoneWithPrefix(phonePrefix = "34", countries = emptyList(), phone = "") {

    }
}