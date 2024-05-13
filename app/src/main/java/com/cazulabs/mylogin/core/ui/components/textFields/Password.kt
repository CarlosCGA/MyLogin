package com.cazulabs.mylogin.core.ui.components.textFields

import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.LockReset
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun Password(label: String = "Password", password: String, onValueChange: (String) -> Unit) {
    var showPassword by rememberSaveable {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier,
        value = password,
        onValueChange = { newPassword ->
            onValueChange(newPassword)
        },
        singleLine = true,
        label = { Text(text = label) },
        leadingIcon = {
            if(label == "Password")
                Icon(imageVector = Icons.Outlined.Lock, contentDescription = "lock")
            else
                Icon(imageVector = Icons.Outlined.LockReset, contentDescription = "lock again")
        },
        trailingIcon = {
            Icon(
                modifier = Modifier.clickable {
                    showPassword = !showPassword
                },
                imageVector =
                if (showPassword)
                    Icons.Outlined.VisibilityOff
                else
                    Icons.Outlined.Visibility,
                contentDescription = label
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation =
        if (showPassword)
            VisualTransformation.None
        else
            PasswordVisualTransformation()
    )
}