package onesky.assessment.feature_country.presentation.country_list

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import onesky.assessment.AppConstants
import onesky.assessment.R
import onesky.assessment.feature_country.presentation.CountryListViewModel
import onesky.assessment.feature_country.presentation.country_list.components.CountryListItem
import onesky.assessment.feature_country.presentation.country_list.components.bottomnavigation.BottomNavigationBar
import onesky.assessment.feature_country.presentation.country_list.components.bottomnavigation.BottomNavItem

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CountryListScreen (
    navController: NavController
){

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val countryList = stringArrayResource(id = R.array.countries_array)

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomNavItem(
                        name = stringResource(id = R.string.str_countries),
                        route = AppConstants.SCREEN_NAME_COUNTRY_LIST,
                        icon = Icons.Default.Home
                    ),
                ),
            )
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Text(
                text = stringResource(id = R.string.str_choose_country),
                style = TextStyle(fontSize = 24.sp),
                fontWeight = FontWeight.Bold
            )
            LazyColumn(modifier = Modifier.fillMaxSize()){
                items(
                    countryList
                ){country ->
                    CountryListItem(countryName = country){
                        navController.navigate(AppConstants.SCREEN_NAME_COUNTRY_DETAIL + "/${country}")
                    }
                }
            }
        }
    }
}