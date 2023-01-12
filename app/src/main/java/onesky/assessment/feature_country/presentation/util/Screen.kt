package onesky.assessment.feature_country.presentation.util

sealed class Screen(val route: String) {
    object CountryListScreen: Screen("country_list_screen")
    object CountryDetailScreen: Screen("country_detail_screen")
}
