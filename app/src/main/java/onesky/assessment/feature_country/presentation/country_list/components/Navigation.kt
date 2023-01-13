package onesky.assessment.feature_country.presentation.country_list.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import onesky.assessment.feature_country.presentation.country_list.CountryListScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
         //   CountryListScreen(navController = navController)
        }
    }
}