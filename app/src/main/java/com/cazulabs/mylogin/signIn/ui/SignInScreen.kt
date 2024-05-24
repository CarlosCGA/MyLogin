package com.cazulabs.mylogin.signIn.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import com.cazulabs.mylogin.core.ui.components.BackScreenButton
import com.cazulabs.mylogin.core.ui.components.textFields.Email
import com.cazulabs.mylogin.core.ui.components.textFields.Password
import com.cazulabs.mylogin.core.ui.components.textFields.PhoneWithPrefix
import com.cazulabs.mylogin.core.ui.components.textFields.Username
import com.cazulabs.mylogin.countriesInformation.ui.CountriesPhonePrefixUiState

@Composable
fun SignInScreen(
    navController: NavController,
    signInViewModel: SignInViewModel = hiltViewModel<SignInViewModel>()
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Header(modifier = Modifier.weight(0.2F), navController = navController)
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
    val lifecycle = LocalLifecycleOwner.current.lifecycle

    val uiState by produceState<CountriesPhonePrefixUiState>(
        initialValue = CountriesPhonePrefixUiState.Loading,
        key1 = lifecycle,
        key2 = signInViewModel
    ) {
        lifecycle.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
            signInViewModel.uiState.collect { value = it }
        }
    }

    val username by signInViewModel.username.observeAsState(initial = "")
    val email by signInViewModel.email.observeAsState(initial = "")
    val phonePrefix by signInViewModel.phonePrefix.observeAsState(initial = "+34")
    val phone by signInViewModel.phone.observeAsState(initial = "")
    val password by signInViewModel.password.observeAsState(initial = "")
    val confirmPassword by signInViewModel.confirmPassword.observeAsState(initial = "")
    val isSignInEnabled by signInViewModel.isSignInEnabled.observeAsState(initial = false)

    Column(modifier = modifier) {
        SignInTitle(modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(24.dp))

        Username(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            username = username
        ) { newUsername ->
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
        Email(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            email = email
        ) { newEmail ->
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            uiState = uiState,
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
            },
            signInViewModel = signInViewModel
        )
        Spacer(modifier = Modifier.size(8.dp))
        Password(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            password = password
        ) { newPassword ->
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
        Password(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            label = "Confirm password", password = confirmPassword
        ) { newConfirmPassword ->
            signInViewModel.onSignInChanged(
                username,
                email,
                phonePrefix,
                phone,
                password,
                newConfirmPassword
            )
        }


        Spacer(modifier = Modifier.size(24.dp))

        ButtonSignIn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
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