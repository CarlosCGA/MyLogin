package com.cazulabs.mylogin.logIn.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cazulabs.mylogin.R
import com.cazulabs.mylogin.core.Routes

@Composable
fun LogInScreen(navigationController: NavHostController, logInViewModel: LogInViewModel) {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(0.33F))
            Body(
                modifier = Modifier
                    .weight(1F)
                    .align(Alignment.CenterHorizontally),
                logInViewModel
            )
            Spacer(modifier = Modifier.size(36.dp))
            Footer(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                navigationController
            )
            Spacer(modifier = Modifier.size(16.dp))
        }
    }
}

@Composable
fun Footer(modifier: Modifier, navigationController: NavHostController) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Do not have account yet? ")
        Text(
            modifier = Modifier.clickable { navigationController.navigate(Routes.SignIn.route) },
            text = "Sign in.",
            color = colorResource(id = R.color.purple_200),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun Body(modifier: Modifier, logInViewModel: LogInViewModel) {
    val email by logInViewModel.email.observeAsState(initial = "")
    val phone by logInViewModel.phone.observeAsState(initial = "")
    val password by logInViewModel.password.observeAsState(initial = "")
    val isLogInEnabled by logInViewModel.isLogInEnabled.observeAsState(initial = false)

    Column(modifier = modifier) {
        LogInTitle(modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(36.dp))

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

        ButtonLogIn(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            isLogInEnabled = isLogInEnabled,
            logInViewModel = logInViewModel
        )
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

@Composable
fun Phone(phone: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        modifier = Modifier,
        value = phone,
        onValueChange = { newPhone ->
            onValueChange(newPhone)
        },
        singleLine = true,
        label = { Text(text = "Phone") },
        leadingIcon = {
            Icon(imageVector = Icons.Outlined.Phone, contentDescription = "phone")
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
    )
}

@Composable
fun Password(password: String, onValueChange: (String) -> Unit) {
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
        label = { Text(text = "Password") },
        leadingIcon = {
            Icon(imageVector = Icons.Outlined.Lock, contentDescription = "lock")
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
                contentDescription = "password"
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

@Composable
fun ButtonLogIn(modifier: Modifier, isLogInEnabled: Boolean, logInViewModel: LogInViewModel) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(6.dp),
        onClick = { logInViewModel.onLogIn() },
        enabled = isLogInEnabled
    ) {
        Text(text = "LogIn")
    }
}


/*
@Preview(showSystemUi = true)
@Composable
fun PreviewLogInScreen() {
    LogInScreen(logInViewModel)
}
*/