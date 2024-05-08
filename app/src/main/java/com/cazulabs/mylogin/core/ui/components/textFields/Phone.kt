package com.cazulabs.mylogin.core.ui.components.textFields

import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Phone(
    phonePrefix: String = "",
    onPhonePrefixChange: (String) -> Unit = {},
    phone: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier,
        value = phone,
        onValueChange = { newPhone ->
            onValueChange(newPhone)
        },
        singleLine = true,
        prefix = {
            if (phonePrefix.isNotEmpty())
                PhonePrefix(phonePrefix = phonePrefix)
        },
        label = { Text(text = "Phone") },
        leadingIcon = {
            Icon(imageVector = Icons.Outlined.Phone, contentDescription = "phone")
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
    )
}

@Composable
fun PhonePrefix(phonePrefix: String) {
    Text(modifier = Modifier.clickable { }, text = "+$phonePrefix", color = Color.Gray)
}

@Preview(showBackground = true)
@Composable
fun PhonePreview() {
    Phone(phonePrefix = "34", phone = "") {

    }
}