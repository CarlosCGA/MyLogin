package com.cazulabs.mylogin.logIn.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.cazulabs.mylogin.core.navigation.Routes
import com.cazulabs.mylogin.core.ui.components.textFields.Email
import com.cazulabs.mylogin.core.ui.components.textFields.Password
import com.cazulabs.mylogin.core.ui.components.textFields.Phone

@Composable
fun LogInScreen(
    navController: NavHostController,
    logInViewModel: LogInViewModel = hiltViewModel<LogInViewModel>(),
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(0.33F))
            Body(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1F)
                    .align(Alignment.CenterHorizontally),
                logInViewModel = logInViewModel,
                navController = navController
            )
            Spacer(modifier = Modifier.size(36.dp))
            Footer(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                navController
            )
            Spacer(modifier = Modifier.size(16.dp))
        }
    }
}

@Composable
fun Footer(modifier: Modifier, navController: NavHostController) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Do not have account yet? ")
        TextButton(onClick = { navController.navigate(Routes.SignIn.route) }) {
            Text(text = "Sign in", fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun Body(modifier: Modifier, logInViewModel: LogInViewModel, navController: NavHostController) {
    val email by logInViewModel.email.observeAsState(initial = "")
    val phone by logInViewModel.phone.observeAsState(initial = "")
    val password by logInViewModel.password.observeAsState(initial = "")
    val isLogInEmailMode by logInViewModel.isLogInEmailMode.observeAsState(initial = true)
    val isLogInEnabled by logInViewModel.isLogInEnabled.observeAsState(initial = false)

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        LogInTitle(modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(36.dp))

        LogInModeSelector(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            email = email,
            phone = phone,
            password = password,
            isLogInEmailMode = isLogInEmailMode,
            logInViewModel = logInViewModel
        )

        AnimatedVisibility(visible = isLogInEmailMode) {
            Email(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                email = email
            ) { newEmail ->
                logInViewModel.onLogInChanged(
                    email = newEmail,
                    phone = phone,
                    password = password,
                    isLogInEmailMode = isLogInEmailMode
                )
            }
        }
        AnimatedVisibility(visible = !isLogInEmailMode) {
            Phone(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                phone = phone
            ) { newPhone ->
                logInViewModel.onLogInChanged(
                    email = email,
                    phone = newPhone,
                    password = password,
                    isLogInEmailMode = isLogInEmailMode
                )
            }
        }
        Spacer(modifier = Modifier.size(8.dp))
        Password(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            password = password
        ) { newPassword ->
            logInViewModel.onLogInChanged(
                email = email,
                phone = phone,
                password = newPassword,
                isLogInEmailMode = isLogInEmailMode
            )
        }

        TextButton(
            onClick = { navController.navigate(Routes.ResetPassword.route) }) {
            Text(text = "Did you forget your password?")
        }

        Spacer(modifier = Modifier.size(12.dp))

        ButtonLogIn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            isLogInEnabled = isLogInEnabled,
            logInViewModel = logInViewModel,
            navController = navController
        )
    }
}

@Composable
fun LogInTitle(modifier: Modifier) {
    Text(
        modifier = modifier,
        text = "Log In",
        fontWeight = FontWeight.Bold
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogInModeSelector(
    modifier: Modifier,
    email: String,
    phone: String,
    password: String,
    isLogInEmailMode: Boolean,
    logInViewModel: LogInViewModel
) {
    Row(modifier = modifier) {
        FilterChip(
            selected = isLogInEmailMode,
            onClick = {
                logInViewModel.onLogInChanged(
                    email = email,
                    phone = phone,
                    password = password,
                    isLogInEmailMode = true
                )
            },
            label = { Text(text = "Email") }
        )
        Spacer(modifier = Modifier.size(8.dp))
        FilterChip(
            selected = !isLogInEmailMode,
            onClick = {
                logInViewModel.onLogInChanged(
                    email = email,
                    phone = phone,
                    password = password,
                    isLogInEmailMode = false
                )
            },
            label = { Text(text = "Phone") }
        )
    }
}

@Composable
fun ButtonLogIn(
    modifier: Modifier,
    isLogInEnabled: Boolean,
    logInViewModel: LogInViewModel,
    navController: NavController
) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(6.dp),
        onClick = {
            val result = logInViewModel.onLogIn()
            if (result)
                navController.navigate(Routes.Home.route)
        },
        enabled = isLogInEnabled
    ) {
        Text(text = "Log In")
    }
}