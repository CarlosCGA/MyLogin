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
import com.cazulabs.mylogin.logIn.ui.Email
import com.cazulabs.mylogin.logIn.ui.Password
import com.cazulabs.mylogin.logIn.ui.Phone

@Composable
fun SignInScreen(signInViewModel: SignInViewModel = hiltViewModel<SignInViewModel>()) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(0.33F))
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
fun Body(modifier: Modifier, signInViewModel: SignInViewModel) {
    val email by signInViewModel.email.observeAsState(initial = "")
    val phone by signInViewModel.phone.observeAsState(initial = "")
    val password by signInViewModel.password.observeAsState(initial = "")
    val isSignInEnabled by signInViewModel.isLogInEnabled.observeAsState(initial = false)

    Column(modifier = modifier) {
        SignInTitle(modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(36.dp))

        Email(email) { newEmail ->
            signInViewModel.onLogInChanged(newEmail, phone, password)
        }
        Spacer(modifier = Modifier.size(8.dp))
        Phone(phone) { newPhone ->
            signInViewModel.onLogInChanged(email, newPhone, password)
        }
        Spacer(modifier = Modifier.size(16.dp))

        Password(password) { newPassword ->
            signInViewModel.onLogInChanged(email, phone, newPassword)
        }

        Spacer(modifier = Modifier.size(24.dp))

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



@Preview(showSystemUi = true)
@Composable
fun SignInScreenPreview() {
    SignInScreen()
}