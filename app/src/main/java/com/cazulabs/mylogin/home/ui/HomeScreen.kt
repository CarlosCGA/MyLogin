package com.cazulabs.mylogin.home.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cazulabs.mylogin.core.ui.components.BackScreenButton


@Composable
fun HomeScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Header(
                modifier = Modifier
                    .weight(1F)
                    .align(Alignment.Start), navController = navController
            )
            Body(
                modifier = Modifier
                    .weight(1F)
                    .align(Alignment.CenterHorizontally)
            )
            Footer(modifier = Modifier.weight(1F))
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
fun Body(modifier: Modifier) {
    Box(modifier = modifier) {
        Text(text = "Hello world")
    }
}

@Composable
fun Footer(modifier: Modifier) {
    Box(modifier = modifier)
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}