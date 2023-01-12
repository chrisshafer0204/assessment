package onesky.myapplication.feature.view.country_list

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CountryListScreen (
    navController: NavController,
    viewModel: CountryListViewModel = hiltViewModel()
){

}