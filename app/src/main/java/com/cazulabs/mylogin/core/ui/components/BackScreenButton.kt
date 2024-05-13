package com.cazulabs.mylogin.core.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun BackScreenButton(navController: NavController) {
    FilledIconButton(
        colors = IconButtonDefaults.iconButtonColors(containerColor = Color.Transparent),
        onClick = { navController.popBackStack() }) {
        Icon(
            imageVector = Icons.Outlined.ArrowBackIosNew,
            contentDescription = "back"
        )
    }
}