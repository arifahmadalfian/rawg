package com.arifahmadalfian.rawgapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.arifahmadalfian.rawgapp.navigation.BottomBar
import com.arifahmadalfian.rawgapp.navigation.BottomNavGraph
import com.arifahmadalfian.rawgapp.presentation.ui.theme.RawgAppTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalCoilApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RawgAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    navController = rememberNavController()

                    Scaffold(
                        bottomBar = {
                            BottomBar(navController = navController)
                        },
                    ) {
                        BottomNavGraph(navController = navController)
                    }
                }
            }
        }
    }
}
