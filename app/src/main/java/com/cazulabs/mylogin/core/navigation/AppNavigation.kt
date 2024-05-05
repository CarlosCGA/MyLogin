package com.cazulabs.mylogin.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cazulabs.mylogin.MainActivity
import com.cazulabs.mylogin.logIn.ui.LogInScreen
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
            LogInScreen(navController, MainActivity().getLogInViewModel())
        }

        composable(Routes.SignIn.route) {
            SignInScreen()
        }

        /*
        composable(Routes.MyScrollableColumn.route) {
            MyScrollableColumn()
        }

        composable(Routes.MySimpleRecyclerView.route) {
            MySimpleRecyclerView()
        }

        composable(Routes.MySuperHeroGridView.route) {
            MySuperHeroGridView()
        }

        composable(Routes.MyScaffold.route + "/{keyOfSimpleArgument}") { backStackEntry ->
            MyDrawer(
                navigationController,
                backStackEntry.arguments!!.getString("keyOfSimpleArgument")!!
            )
        }

        composable(
            Routes.MyListOfArgumentsPassThrough.route + "/{firstKeyOfArgumentList}/{secondKeyOfArgumentList}"
        ) { backStackEntry ->
            MyScreenWithInputArguments(
                firstArgument = backStackEntry.arguments!!.getString("firstKeyOfArgumentList")!!,
                secondArgument = backStackEntry.arguments!!.getInt("secondKeyOfArgumentList")
            )
        }

        composable(
            Routes.MyListOfOptionalArgumentsPassThrough.route,
            arguments = listOf(
                navArgument("name") { defaultValue = "Towel" },
                navArgument("age") { defaultValue = 0 },
            )
        ) { backStackEntry ->
            MyScreenWithOptionalInputArguments(
                firstArgument = backStackEntry.arguments!!.getString("name"),
                secondArgument = backStackEntry.arguments!!.getInt("age")
            )
        }*/
    }
}