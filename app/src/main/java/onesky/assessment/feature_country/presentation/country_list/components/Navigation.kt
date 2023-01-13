package onesky.assessment.feature_country.presentation.country_list.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import onesky.assessment.AppConstants
import onesky.assessment.AppConstants.SCREEN_NAME_COUNTRY_DETAIL
import onesky.assessment.AppConstants.SCREEN_NAME_COUNTRY_LIST
import onesky.assessment.feature_country.presentation.country_detail.CountryDetailScreen
import onesky.assessment.feature_country.presentation.country_list.CountryListScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = SCREEN_NAME_COUNTRY_LIST
    ) {
        composable(SCREEN_NAME_COUNTRY_LIST) {
            CountryListScreen(navController = navController)
        }
        composable(SCREEN_NAME_COUNTRY_DETAIL,
            arguments = listOf(navArgument(AppConstants.NAV_ARGUMENT_COUNTRY_NAME) {
                defaultValue = ""
            })
        ) { navBackStackEntry ->
            CountryDetailScreen(
                navBackStackEntry.arguments?.getString(AppConstants.NAV_ARGUMENT_COUNTRY_NAME),
                navController
            )
        }
    }
}