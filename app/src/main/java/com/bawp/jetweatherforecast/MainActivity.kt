package com.bawp.jetweatherforecast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bawp.jetweatherforecast.navigation.WeatherNavigation
import com.bawp.jetweatherforecast.ui.theme.JetWeatherForecastTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherApp()

        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun WeatherApp() {

    JetWeatherForecastTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background,
                modifier = Modifier.fillMaxSize()) {
               Column(verticalArrangement = Arrangement.Center,
                     horizontalAlignment = Alignment.CenterHorizontally) {
                   WeatherNavigation()

               }

        }
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetWeatherForecastTheme {

    }
}