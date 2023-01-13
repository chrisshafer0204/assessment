package onesky.assessment.feature_country.presentation.country_list.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import onesky.assessment.AppConstants
import onesky.assessment.AppConstants.SCREEN_NAME_COUNTRY_DETAIL
import onesky.assessment.AppConstants.SCREEN_NAME_COUNTRY_LIST
import onesky.assessment.feature_country.presentation.country_detail.CountryDetailScreen
import onesky.assessment.feature_country.presentation.country_list.CountryListScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = SCREEN_NAME_COUNTRY_LIST,
    ) {
        composable(route = SCREEN_NAME_COUNTRY_LIST) {
            CountryListScreen(navController = navController)
        }
        composable(
            route = "$SCREEN_NAME_COUNTRY_DETAIL/{country_name}",
            arguments = listOf(
                navArgument("country_name") {
                    type = NavType.StringType
                defaultValue = ""
            })
        ) { navBackStackEntry ->
            CountryDetailScreen(
                countryName =
                navBackStackEntry.arguments?.getString(AppConstants.NAV_ARGUMENT_COUNTRY_NAME)!!,
            )
        }
    }
}