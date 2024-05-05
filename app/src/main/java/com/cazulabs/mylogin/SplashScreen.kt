package com.cazulabs.mylogin

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cazulabs.mylogin.core.Routes
import com.cazulabs.mylogin.logIn.ui.LogInScreen
import com.cazulabs.mylogin.logIn.ui.LogInViewModel
import com.cazulabs.mylogin.signIn.ui.SignInScreen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onNext: () -> Unit) {
    var time: Int by remember { mutableIntStateOf(3) }

    LaunchedEffect(key1 = time) {
        while (time > 0) {
            delay(1000L)
            time--
        }

        if (time == 0)
            onNext()
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center)
    {
        Icon(
            modifier = Modifier
                .size(40.dp)
                .clickable { onNext() },
            imageVector = Icons.Outlined.Image,
            contentDescription = "image"
        )
    }
}

@Composable
fun LogInApp(
    logInViewModel: LogInViewModel,
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = Routes.valueOf(
        backStackEntry?.destination?.route ?: Routes.Start.name
    )

    NavHost(
        navController = navController,
        startDestination = Routes.Start.route
    ) {

        composable(Routes.Start.route) {
            SplashScreen {
                navController.popBackStack()
                navController.navigate(Routes.LogIn.route)
            }
        }

        composable(Routes.LogIn.route) {
            LogInScreen(logInViewModel = logInViewModel, navController = navController)
        }

        composable(Routes.SignIn.route) {
            SignInScreen(onNavigateUp = { navController.navigateUp() })
        }
    }
}