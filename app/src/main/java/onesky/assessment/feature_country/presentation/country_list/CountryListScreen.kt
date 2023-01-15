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
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import onesky.assessment.R
import onesky.assessment.feature_country.presentation.components.SubTitle
import onesky.assessment.feature_country.presentation.components.TopBar
import onesky.assessment.feature_country.presentation.country_list.bottomnavigation.BottomNavigationBar
import onesky.assessment.feature_country.presentation.country_list.bottomnavigation.BottomNavItem
import onesky.assessment.feature_country.presentation.utils.Screen

@Composable
fun CountryListScreen(
    navController: NavController
) {

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val countryList = stringArrayResource(id = R.array.countries_array)
    var text by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(""))
    }


    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(title = stringResource(id = R.string.str_countries)) },
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomNavItem(
                        name = stringResource(id = R.string.str_countries),
                        route = Screen.CountryList.route,
                        icon = Icons.Default.Home
                    ),
                ),
            )
        },
    ) {paddingValues->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Add Title
            SubTitle(subTitle = stringResource(id = R.string.str_choose_country))
            //Place the composable SearchView wherever is needed
            TextField(
                value = text,
                onValueChange = { it-> text = it },
                label = { Text("Enter country name") }
            )

            val searchKey = text.text
            // Set Country List
            CountryList(navController = navController, countryList = countryList, searchKey)

        }
    }
}
@Composable
fun CountryList(navController: NavController, countryList: Array<String>, searchKey: String) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items = countryList.filter {
            it.lowercase().contains(searchKey)
        }) { country ->

            CountryListItem(countryName = country, onClickCountry = {
                navController.navigate(route = Screen.CountryDetail.passCountryName(country)) {
                    popUpTo("countries")
                }
            })
            
        }

    }
}