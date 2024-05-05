package com.cazulabs.mylogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cazulabs.mylogin.core.Routes
import com.cazulabs.mylogin.logIn.ui.LogInScreen
import com.cazulabs.mylogin.logIn.ui.LogInViewModel
import com.cazulabs.mylogin.signIn.ui.SignInScreen
import com.cazulabs.mylogin.ui.theme.MyLoginTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val logInViewModel: LogInViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.LogIn.route
                    ) {

                        composable(Routes.LogIn.route) {
                            LogInScreen(navigationController, logInViewModel)
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

                    LogInScreen(navigationController, logInViewModel)
                }
            }
        }
    }
}