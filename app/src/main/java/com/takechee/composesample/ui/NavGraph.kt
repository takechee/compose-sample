package com.takechee.composesample.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.takechee.composesample.ui.animal.AnimalPage
import com.takechee.composesample.ui.animals.AnimalsPage

/**
 * Destinations used in the ([ComposeSampleApp]).
 */
object MainDestinations {
    const val ANIMALS_ROUTE = "animals"
    const val ANIMAL_DETAIL_ROUTE = "animal"
    const val ANIMAL_DETAIL_ID_KEY = "animalId"
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
            AnimalsPage(selectAnimal = actions.selectAnimal)
        }
        composable(
            route = "${MainDestinations.ANIMAL_DETAIL_ROUTE}/{${MainDestinations.ANIMAL_DETAIL_ID_KEY}}",
            arguments = listOf(
                navArgument(name = MainDestinations.ANIMAL_DETAIL_ID_KEY) {
                    type = NavType.IntType
                }
            ),
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            AnimalPage(
                animalId = arguments.getInt(MainDestinations.ANIMAL_DETAIL_ID_KEY),
                upPress = actions.upPress,
            )
        }
    }
}

/**
 * Models the navigation actions in the app.
 */
class MainActions(navController: NavHostController) {
    val selectAnimal: (Int) -> Unit = { animalId: Int ->
        navController.navigate("${MainDestinations.ANIMAL_DETAIL_ROUTE}/$animalId")
    }
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}
