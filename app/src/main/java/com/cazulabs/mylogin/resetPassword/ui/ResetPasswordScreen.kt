package com.cazulabs.mylogin.resetPassword.ui

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
    val password by resetPasswordViewModel.password.observeAsState(initial = "")
    val confirmPassword by resetPasswordViewModel.confirmPassword.observeAsState(initial = "")
    val isResetPasswordEnabled by resetPasswordViewModel.isResetPasswordEnabled.observeAsState(false)

    Column(modifier = modifier) {
        ResetPasswordTitle(modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(24.dp))

        Email(
            email = email
        ) { newEmail ->
            resetPasswordViewModel.onResetPasswordChange(
                email = newEmail,
                password = password,
                confirmPassword = confirmPassword
            )
        }
        Spacer(modifier = Modifier.size(8.dp))
        Password(password = password) { newPassword ->
            resetPasswordViewModel.onResetPasswordChange(
                email = email,
                password = newPassword,
                confirmPassword = confirmPassword
            )
        }
        Spacer(modifier = Modifier.size(8.dp))
        Password(label = "Confirm password", password = confirmPassword) { newConfirmPassword ->
            resetPasswordViewModel.onResetPasswordChange(
                email = email,
                password = password,
                confirmPassword = newConfirmPassword
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

@Composable
fun ButtonReset(modifier: Modifier, isResetPasswordEnabled: Boolean, resetPasswordViewModel: ResetPasswordViewModel) {
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