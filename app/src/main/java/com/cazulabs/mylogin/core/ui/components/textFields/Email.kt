package com.cazulabs.mylogin.core.ui.components.textFields

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun Email(email: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        modifier = Modifier,
        value = email,
        onValueChange = { newEmail ->
            onValueChange(newEmail)
        },
        singleLine = true,
        label = { Text(text = "Email") },
        leadingIcon = {
            Icon(imageVector = Icons.Outlined.Email, contentDescription = "email")
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
}