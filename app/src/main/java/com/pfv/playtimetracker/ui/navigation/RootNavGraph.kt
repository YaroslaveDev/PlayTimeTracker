package com.pfv.playtimetracker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pfv.playtimetracker.ui.navigation.constants.Routes
import com.pfv.playtimetracker.ui.screens.home.HomeScreen

@Composable
fun RootNavGraph(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = Routes.HomeScreen
    ){

        composable<Routes.HomeScreen> {

            HomeScreen(navController = navController)
        }
    }
}