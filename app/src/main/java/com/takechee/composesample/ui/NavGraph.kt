package com.takechee.composesample.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.takechee.composesample.ui.animals.AnimalsPage

/**
 * Destinations used in the ([ComposeSampleApp]).
 */
object MainDestinations {
    const val ANIMALS_ROUTE = "animals"
}

@Composable
fun NavGraph(startDestination: String = MainDestinations.ANIMALS_ROUTE) {
    val navController = rememberNavController()

    val actions = remember(navController) { MainActions(navController) }
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.ANIMALS_ROUTE) {
            AnimalsPage()
        }
    }
}

/**
 * Models the navigation actions in the app.
 */
class MainActions(navController: NavHostController) {
}
