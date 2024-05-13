package com.cazulabs.mylogin.core.navigation

sealed class Routes(val route: String) {

    data object Splash: Routes("Splash")
    data object LogIn: Routes("LogIn")
    data object SignIn: Routes("SignIn")
    data object ResetPassword: Routes("ResetPassword")

}