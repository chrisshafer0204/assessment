package onesky.assessment.feature_country.presentation.country_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import onesky.assessment.R
import onesky.assessment.feature_country.presentation.components.SubTitle
import onesky.assessment.feature_country.presentation.components.TopBar
import onesky.assessment.feature_country.presentation.country_list.bottomnavigation.BottomNavigationBar
import onesky.assessment.feature_country.presentation.country_list.bottomnavigation.BottomNavItem
import onesky.assessment.feature_country.presentation.utils.Screen
import onesky.assessment.ui.theme.AssessmentTheme
import onesky.assessment.ui.theme.SearchBackground

@Composable
fun CountryListScreen(
    navController: NavController
) {

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val countryList = stringArrayResource(id = R.array.countries_array)
    var textValue by rememberSaveable(stateSaver = TextFieldValue.Saver) {
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
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
                .padding(top = 20.dp, start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            //Place the composable SearchView wherever is needed
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                value = textValue,
                onValueChange = {
                    if (!it.text.contains("\n"))
                        textValue = it
                },
                label = { Text(stringResource(id = R.string.str_search_country)) },
                maxLines = 1,
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = SearchBackground,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.DarkGray,
                    cursorColor = Color.LightGray
                ),
            )

            val searchKey = textValue.text
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