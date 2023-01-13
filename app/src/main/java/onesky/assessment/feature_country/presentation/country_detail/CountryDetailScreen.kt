package onesky.assessment.feature_country.presentation.country_detail

import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import onesky.assessment.feature_country.presentation.util.Screen

@Composable
fun Screen.CountryDetailScreen(
    viewModel: CountryDetailViewModel = hiltViewModel()
){
    val scaffoldState = rememberScaffoldState()

}