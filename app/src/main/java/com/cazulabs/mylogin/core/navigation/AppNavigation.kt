package com.cazulabs.mylogin.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cazulabs.mylogin.logIn.ui.LogInScreen
import com.cazulabs.mylogin.resetPassword.ui.ResetPasswordScreen
import com.cazulabs.mylogin.signIn.ui.SignInScreen
import com.cazulabs.mylogin.splashScreen.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Splash.route
    ) {

        composable(Routes.Splash.route) {
            SplashScreen{
                navController.popBackStack()
                navController.navigate(Routes.LogIn.route)
            }
        }

        composable(Routes.LogIn.route) {
            LogInScreen(navController = navController)
        }

        composable(Routes.SignIn.route) {
            SignInScreen(navController = navController)
        }

        composable(Routes.ResetPassword.route) {
            ResetPasswordScreen(navController = navController)
        }
    }
}