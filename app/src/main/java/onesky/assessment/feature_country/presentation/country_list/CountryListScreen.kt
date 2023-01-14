package onesky.assessment.feature_country.presentation.country_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.navigation.NavController
import onesky.assessment.AppConstants
import onesky.assessment.R
import onesky.assessment.feature_country.presentation.components.CountryListItem
import onesky.assessment.feature_country.presentation.components.SubTitle
import onesky.assessment.feature_country.presentation.components.TopBar
import onesky.assessment.feature_country.presentation.components.bottomnavigation.BottomNavigationBar
import onesky.assessment.feature_country.presentation.components.bottomnavigation.BottomNavItem

@Composable
fun CountryListScreen(
    navController: NavController
) {

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val countryList = stringArrayResource(id = R.array.countries_array)

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(title = stringResource(id = R.string.str_countries)) },
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
        InitUI(paddingValues = it, navController = navController, countryList = countryList)
    }
}

@Composable
fun InitUI(paddingValues: PaddingValues, navController: NavController, countryList: Array<String>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Add Title
        SubTitle(subTitle = stringResource(id = R.string.str_choose_country))

        // Set Country List
        CountryList(navController = navController, countryList = countryList)

    }
}


@Composable
fun CountryList(navController: NavController, countryList: Array<String>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(
            countryList
        ) { country ->
            CountryListItem(countryName = country) {
                navController.navigate(AppConstants.SCREEN_NAME_COUNTRY_DETAIL + "/${country}")
            }
        }
    }
}