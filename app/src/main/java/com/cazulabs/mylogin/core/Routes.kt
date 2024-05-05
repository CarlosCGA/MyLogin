package com.cazulabs.mylogin.core

sealed class Routes(val route: String) {

    data object LogIn: Routes("LogIn")
    data object SignIn: Routes("SignIn")

}