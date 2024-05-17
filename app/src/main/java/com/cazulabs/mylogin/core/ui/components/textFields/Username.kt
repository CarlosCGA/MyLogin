package com.cazulabs.mylogin.core.ui.components.textFields

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun Username(modifier: Modifier = Modifier, username: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        modifier = modifier,
        value = username,
        onValueChange = { newUsername ->
            onValueChange(newUsername)
        },
        singleLine = true,
        label = { Text(text = "Username") },
        leadingIcon = {
            Icon(imageVector = Icons.Outlined.AccountCircle, contentDescription = "username")
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )
}