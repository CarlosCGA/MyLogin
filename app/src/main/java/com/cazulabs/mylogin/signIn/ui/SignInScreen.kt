package com.cazulabs.mylogin.signIn.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cazulabs.mylogin.core.ui.components.BackScreenButton
import com.cazulabs.mylogin.core.ui.components.textFields.Email
import com.cazulabs.mylogin.core.ui.components.textFields.Password
import com.cazulabs.mylogin.core.ui.components.textFields.PhoneWithPrefix
import com.cazulabs.mylogin.core.ui.components.textFields.Username

@Composable
fun SignInScreen(
    navController: NavController,
    signInViewModel: SignInViewModel = hiltViewModel<SignInViewModel>()
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Header(modifier = Modifier.weight(0.25F), navController = navController)
            Body(
                modifier = Modifier
                    .weight(1F)
                    .align(Alignment.CenterHorizontally),
                signInViewModel
            )
        }
    }
}

@Composable
fun Header(modifier: Modifier, navController: NavController) {
    Box(modifier = modifier) {
        BackScreenButton(navController = navController)
    }
}

@Composable
fun Body(modifier: Modifier, signInViewModel: SignInViewModel) {
    val username by signInViewModel.username.observeAsState(initial = "")
    val email by signInViewModel.email.observeAsState(initial = "")
    val countriesPhonePrefix by signInViewModel.countriesPhonePrefix.observeAsState(initial = emptyList())
    val phonePrefix by signInViewModel.phonePrefix.observeAsState(initial = "+34")
    val phone by signInViewModel.phone.observeAsState(initial = "")
    val password by signInViewModel.password.observeAsState(initial = "")
    val confirmPassword by signInViewModel.confirmPassword.observeAsState(initial = "")
    val isSignInEnabled by signInViewModel.isSignInEnabled.observeAsState(initial = false)

    Column(modifier = modifier) {
        SignInTitle(modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(24.dp))

        Username(username) { newUsername ->
            signInViewModel.onSignInChanged(
                newUsername,
                email,
                phonePrefix,
                phone,
                password,
                confirmPassword
            )
        }
        Spacer(modifier = Modifier.size(8.dp))
        Email(email) { newEmail ->
            signInViewModel.onSignInChanged(
                username,
                newEmail,
                phonePrefix,
                phone,
                password,
                confirmPassword
            )
        }
        Spacer(modifier = Modifier.size(8.dp))
        PhoneWithPrefix(
            countriesPhonePrefix = countriesPhonePrefix,
            phonePrefix = phonePrefix,
            onPhonePrefixChange = { newPhonePrefix ->
                signInViewModel.onSignInChanged(
                    username,
                    email,
                    newPhonePrefix,
                    phone,
                    password,
                    confirmPassword
                )
            },
            phone = phone,
            onValueChange = { newPhone ->
                signInViewModel.onSignInChanged(
                    username,
                    email,
                    phonePrefix,
                    newPhone,
                    password,
                    confirmPassword
                )
            }
        )
        Spacer(modifier = Modifier.size(8.dp))
        Password(password = password) { newPassword ->
            signInViewModel.onSignInChanged(
                username,
                email,
                phonePrefix,
                phone,
                newPassword,
                confirmPassword
            )
        }
        Spacer(modifier = Modifier.size(8.dp))
        Password(label = "Confirm password", password = confirmPassword) { newConfirmPassword ->
            signInViewModel.onSignInChanged(
                username,
                email,
                phonePrefix,
                phone,
                password,
                newConfirmPassword
            )
        }

        Spacer(modifier = Modifier.size(36.dp))

        ButtonSignIn(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            isLogInEnabled = isSignInEnabled,
            signInViewModel = signInViewModel
        )
    }
}

@Composable
fun ButtonSignIn(modifier: Modifier, isLogInEnabled: Boolean, signInViewModel: SignInViewModel) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(6.dp),
        onClick = { signInViewModel.onSignIn() },
        enabled = isLogInEnabled
    ) {
        Text(text = "Sign In")
    }
}

@Composable
fun SignInTitle(modifier: Modifier) {
    Text(
        modifier = modifier,
        text = "Sign In",
        fontWeight = FontWeight.Bold
    )
}