package com.bawp.jetweatherforecast.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bawp.jetweatherforecast.screens.about.AboutScreen
import com.bawp.jetweatherforecast.screens.favorites.FavoritesScreen
import com.bawp.jetweatherforecast.screens.main.MainScreen
import com.bawp.jetweatherforecast.screens.main.MainViewModel
import com.bawp.jetweatherforecast.screens.search.SearchScreen
import com.bawp.jetweatherforecast.screens.settings.SettingsScreen
import com.bawp.jetweatherforecast.screens.splash.WeatherSplashScreen

@ExperimentalComposeUiApi
@Composable
fun WeatherNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = WeatherScreens.SplashScreen.name ) {
        composable(WeatherScreens.SplashScreen.name){
            WeatherSplashScreen(navController = navController)
        }

        //www.google.com/cityname="seattle"
        val route = WeatherScreens.MainScreen.name
        composable("$route/{city}",
                  arguments = listOf(
                      navArgument(name = "city"){
                          type = NavType.StringType
                      })){ navBack ->
            navBack.arguments?.getString("city").let { city ->

                val mainViewModel = hiltViewModel<MainViewModel>()
                MainScreen(navController = navController, mainViewModel,
                          city = city)
            }


        }

        composable(WeatherScreens.SearchScreen.name){
            SearchScreen(navController = navController)
        }

        composable(WeatherScreens.AboutScreen.name){
            AboutScreen(navController = navController)
        }
        composable(WeatherScreens.SettingsScreen.name){
            SettingsScreen(navController = navController)
        }

        composable(WeatherScreens.FavoriteScreen.name){
            FavoritesScreen(navController = navController)
        }

    }
}