package com.mujeeapps.cryptorapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mujeeapps.cryptorapp.presentation.coin_details.CoinDetailsScreen
import com.mujeeapps.cryptorapp.presentation.coins.CoinListScreen
import com.mujeeapps.cryptorapp.presentation.theme.CryptorAppTheme
import dagger.hilt.android.AndroidEntryPoint

//Hilt entry point
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptorAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController,
                        startDestination = Screen.CoinListScreen.route) {
                        composable(
                            route = Screen.CoinListScreen.route
                        ) {
                            CoinListScreen(navController)
                        }
                        composable(
                            route = Screen.CoinDetailsScreen.route + "/{coinId}"
                        ) {
                            CoinDetailsScreen()
                        }
                    }
                }
            }
        }
    }
}