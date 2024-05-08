package com.cazulabs.mylogin.logIn.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cazulabs.mylogin.core.navigation.Routes
import com.cazulabs.mylogin.core.ui.components.textFields.Email
import com.cazulabs.mylogin.core.ui.components.textFields.Password
import com.cazulabs.mylogin.core.ui.components.textFields.Phone

@Composable
fun LogInScreen(
    navController: NavHostController,
    logInViewModel: LogInViewModel = hiltViewModel<LogInViewModel>()
) {
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
                navController
            )
            Spacer(modifier = Modifier.size(16.dp))
        }
    }
}

@Composable
fun Footer(modifier: Modifier, navigationController: NavHostController) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Do not have account yet? ")
        TextButton(onClick = { navigationController.navigate(Routes.SignIn.route) }) {
            Text(text = "Sign in", fontWeight = FontWeight.Bold)
        }
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

        Password(password = password) { newPassword ->
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
        text = "Log In",
        fontWeight = FontWeight.Bold
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
        Text(text = "Log In")
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewLogInScreen() {
    LogInScreen(rememberNavController(), hiltViewModel<LogInViewModel>())
}
