package onesky.assessment.feature_country.presentation.utils

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import onesky.assessment.feature_country.presentation.country_detail.CountryDetailScreen
import onesky.assessment.feature_country.presentation.country_list.CountryListScreen
import onesky.assessment.feature_country.presentation.map.CountryMapScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.CountryList.route,
    ) {
        composable(route = Screen.CountryList.route) {
            CountryListScreen(navController = navController)
        }
        composable(
            route = Screen.CountryDetail.route,
            arguments = listOf(
                navArgument(COUNTRY_NAME_ARGUMENT_KEY) {
                    type = NavType.StringType
                defaultValue = ""
            })
        ) { navBackStackEntry ->

            CountryDetailScreen(
                navController = navController,
                countryName =
                navBackStackEntry.arguments?.getString(COUNTRY_NAME_ARGUMENT_KEY)!!,
            )
        }
        composable(
            Screen.CountryMap.route,
            arguments = listOf(
                navArgument(COUNTRY_LATITUDE_ARGUMENT_KEY) {
                    type = NavType.FloatType
                    defaultValue = 0.0f
                },
                navArgument(COUNTRY_LONGITUDE_ARGUMENT_KEY) {
                    type = NavType.FloatType
                    defaultValue = 0.0f
                }
            )
        ) {navBackStackEntry ->
            CountryMapScreen(
                 latitude =  navBackStackEntry.arguments?.getFloat(COUNTRY_LATITUDE_ARGUMENT_KEY)!!,
                longitude =  navBackStackEntry.arguments?.getFloat(COUNTRY_LONGITUDE_ARGUMENT_KEY)!!
            )
        }
    }
}