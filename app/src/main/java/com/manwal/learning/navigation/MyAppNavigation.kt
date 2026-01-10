package com.manwal.learning.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun myAppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.ScreenA, builder = {
        composable(Routes.ScreenA) {
            ScreenA(navController)
        }
        composable(Routes.ScreenB + "/{name}") {
            val name = it.arguments?.getString("name")
            ScreenB(name ?: "No name passed")
        }
    })
}