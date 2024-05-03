package com.cazulabs.mylogin.logIn.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LogInScreen(logInViewModel: LogInViewModel) {

    Box(modifier = Modifier.fillMaxSize()) {
        //Header(modifier = Modifier.align(Alignment.TopCenter))
        //Body(modifier = Modifier.align(Alignment.Center))
        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(0.33F))
            Body(
                modifier = Modifier
                    .weight(1F)
                    .align(Alignment.CenterHorizontally),
                logInViewModel
            )
        }

    }
}

@Composable
fun Body(modifier: Modifier, logInViewModel: LogInViewModel) {
    val email by logInViewModel.email.observeAsState(initial = "")
    val phone by logInViewModel.phone.observeAsState(initial = "")
    val password by logInViewModel.password.observeAsState(initial = "")

    Column(modifier = modifier) {
        LogInTitle(modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(36.dp))
        LogInModeSelector(modifier = Modifier.align(Alignment.CenterHorizontally))

        Email(email) { newEmail ->
            logInViewModel.onLogInChanged(newEmail, phone, password)
        }
        Spacer(modifier = Modifier.size(8.dp))
        Phone(phone) { newPhone ->
            logInViewModel.onLogInChanged(email, newPhone, password)
        }
        Spacer(modifier = Modifier.size(16.dp))
        Password(password) { newPassword ->
            logInViewModel.onLogInChanged(email, phone, newPassword)
        }

        Spacer(modifier = Modifier.size(24.dp))

        ButtonLogIn(modifier = Modifier.align(Alignment.CenterHorizontally))
    }
}

@Composable
fun LogInTitle(modifier: Modifier) {
    Text(
        modifier = modifier,
        text = "LogIn",
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun LogInModeSelector(modifier: Modifier) {
    Switch(modifier = modifier, checked = false, onCheckedChange = {})

}

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
    )
}

@Composable
fun Phone(phone: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        modifier = Modifier,
        value = phone,
        onValueChange = { newPhone ->
            onValueChange(newPhone)
        },
        singleLine = true,
        label = { Text(text = "Phone") }
    )
}

@Composable
fun Password(password: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        modifier = Modifier,
        value = password,
        onValueChange = { newPassword ->
            onValueChange(newPassword)
        },
        singleLine = true,
        label = { Text(text = "Password") },
        trailingIcon = {
            Icon(
                imageVector = Icons.Outlined.Visibility,
                contentDescription = "password"
            )
        }
    )
}

@Composable
fun ButtonLogIn(modifier: Modifier) {
    Button(modifier = modifier, shape = RoundedCornerShape(6.dp), onClick = { /*TODO*/ }) {
        Text(text = "LogIn")
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewLogInScreen() {
    LogInScreen(LogInViewModel())
}