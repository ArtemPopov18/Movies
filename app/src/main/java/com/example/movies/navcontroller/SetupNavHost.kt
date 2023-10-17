package com.example.movies.navcontroller

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movies.screens.MainScreens
import com.example.movies.screens.SplashScreen
import com.example.movies.utils.Constants

sealed class Screens(val route: String){
    object Splash: Screens(route = Constants.Screens.SPLASH_SCREENS)
    object Main: Screens(route = Constants.Screens.MAIN_SCREENS)
    object Details: Screens(route = Constants.Screens.DETAILS_SCREENS)
}

@Composable
fun SetupNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {
        composable(route = Screens.Splash.route){
            SplashScreen(navController = navController)
        }
        composable(route = Screens.Main.route){
            MainScreens()
        }
        composable(route = Screens.Details.route){

        }
    }
}