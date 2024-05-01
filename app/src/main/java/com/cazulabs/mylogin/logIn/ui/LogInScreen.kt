package com.cazulabs.mylogin.logIn.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun LogInScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        //Header(modifier = Modifier.align(Alignment.TopCenter))
        //Body(modifier = Modifier.align(Alignment.Center))
        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(0.33F))
            Body(modifier = Modifier
                .weight(1F)
                .align(Alignment.CenterHorizontally))
        }

    }
}

@Composable
fun Body(modifier: Modifier) {
    Column(modifier = modifier) {
        LogInTitle(modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(36.dp))
        InputEmail()
    }
}

@Composable
fun LogInTitle(modifier: Modifier) {
    Text(
        modifier = modifier,
        text = "LogIn",
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun InputEmail() {
    TextField(modifier = Modifier, value = "", onValueChange = {})
}

@Composable
fun InputPhone() {

}

@Composable
fun InputPassword() {
    TextField(modifier = Modifier, value = "", onValueChange = {})
}