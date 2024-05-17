package com.cazulabs.mylogin.resetPassword.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
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
import com.cazulabs.mylogin.core.ui.components.textFields.Phone

@Composable
fun ResetPasswordScreen(
    navController: NavController,
    resetPasswordViewModel: ResetPasswordViewModel = hiltViewModel<ResetPasswordViewModel>()
) {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Header(
                modifier = Modifier
                    .weight(0.3F)
                    .align(Alignment.Start),
                navController = navController
            )
            Body(
                modifier = Modifier
                    .weight(1F)
                    .align(Alignment.CenterHorizontally),
                resetPasswordViewModel = resetPasswordViewModel
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
fun Body(
    modifier: Modifier,
    resetPasswordViewModel: ResetPasswordViewModel
) {
    val email by resetPasswordViewModel.email.observeAsState(initial = "")
    val phone by resetPasswordViewModel.phone.observeAsState(initial = "")
    val password by resetPasswordViewModel.password.observeAsState(initial = "")
    val confirmPassword by resetPasswordViewModel.confirmPassword.observeAsState(initial = "")
    val isResetPasswordEnabled by resetPasswordViewModel.isResetPasswordEnabled.observeAsState(false)
    val isResetPasswordEmailMode by resetPasswordViewModel.isResetPasswordEmailMode.observeAsState(true)

    Column(modifier = modifier) {
        ResetPasswordTitle(modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(24.dp))

        ResetPasswordModeSelector(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            email = email,
            phone = phone,
            password = password,
            confirmPassword = confirmPassword,
            isResetPasswordEmailMode = isResetPasswordEmailMode,
            resetPasswordViewModel = resetPasswordViewModel
        )

        AnimatedVisibility(visible = isResetPasswordEmailMode) {
            Email(
                email = email
            ) { newEmail ->
                resetPasswordViewModel.onResetPasswordChange(
                    email = newEmail,
                    phone = phone,
                    password = password,
                    confirmPassword = confirmPassword,
                    isResetPasswordEmailMode = isResetPasswordEmailMode
                )
            }
        }
        AnimatedVisibility(visible = !isResetPasswordEmailMode) {
            Phone(phone = phone) {newPhone ->
                resetPasswordViewModel.onResetPasswordChange(
                    email = email,
                    phone = newPhone,
                    password = password,
                    confirmPassword = confirmPassword,
                    isResetPasswordEmailMode = isResetPasswordEmailMode
                )
            }
        }
        Spacer(modifier = Modifier.size(8.dp))
        Password(password = password) { newPassword ->
            resetPasswordViewModel.onResetPasswordChange(
                email = email,
                phone = phone,
                password = newPassword,
                confirmPassword = confirmPassword,
                isResetPasswordEmailMode = isResetPasswordEmailMode
            )
        }
        Spacer(modifier = Modifier.size(8.dp))
        Password(label = "Confirm password", password = confirmPassword) { newConfirmPassword ->
            resetPasswordViewModel.onResetPasswordChange(
                email = email,
                phone = phone,
                password = password,
                confirmPassword = newConfirmPassword,
                isResetPasswordEmailMode = isResetPasswordEmailMode
            )
        }

        Spacer(modifier = Modifier.size(24.dp))

        ButtonReset(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            isResetPasswordEnabled = isResetPasswordEnabled,
            resetPasswordViewModel = resetPasswordViewModel
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResetPasswordModeSelector(
    modifier: Modifier,
    email: String,
    phone: String,
    password: String,
    confirmPassword: String,
    isResetPasswordEmailMode: Boolean,
    resetPasswordViewModel: ResetPasswordViewModel
) {
    Row(modifier = modifier) {
        FilterChip(
            selected = isResetPasswordEmailMode,
            onClick = {
                resetPasswordViewModel.onResetPasswordChange(
                    email = email,
                    phone = phone,
                    password = password,
                    confirmPassword = confirmPassword,
                    isResetPasswordEmailMode = true
                )
            },
            label = { Text(text = "Email") }
        )
        Spacer(modifier = Modifier.size(8.dp))
        FilterChip(
            selected = !isResetPasswordEmailMode,
            onClick = {
                resetPasswordViewModel.onResetPasswordChange(
                    email = email,
                    phone = phone,
                    password = password,
                    confirmPassword = confirmPassword,
                    isResetPasswordEmailMode = false
                )
            },
            label = { Text(text = "Phone") }
        )
    }
}

@Composable
fun ButtonReset(
    modifier: Modifier,
    isResetPasswordEnabled: Boolean,
    resetPasswordViewModel: ResetPasswordViewModel
) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(6.dp),
        onClick = { resetPasswordViewModel.onDoResetPassword() },
        enabled = isResetPasswordEnabled
    ) {
        Text(text = "Reset")
    }
}

@Composable
fun ResetPasswordTitle(modifier: Modifier) {
    Text(
        modifier = modifier,
        text = "Reset password",
        fontWeight = FontWeight.Bold
    )
}

@Preview(showSystemUi = true)
@Composable
fun ResetPasswordPreview() {
    ResetPasswordScreen(navController = rememberNavController())
}