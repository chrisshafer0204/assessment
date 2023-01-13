package onesky.assessment.feature_country.presentation.country_detail

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CountryDetailScreen(
    countryName: String?,
    navController: NavController,
    viewModel: CountryDetailViewModel = hiltViewModel()
){
    val scaffoldState = rememberScaffoldState()

}