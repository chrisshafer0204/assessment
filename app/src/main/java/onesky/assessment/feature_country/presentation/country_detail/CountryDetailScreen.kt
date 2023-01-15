package onesky.assessment.feature_country.presentation.country_detail

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import onesky.assessment.R
import onesky.assessment.feature_country.domain.model.RowInfo
import onesky.assessment.feature_country.domain.model.country.Country
import onesky.assessment.feature_country.domain.network.ResultData
import onesky.assessment.feature_country.presentation.CountryViewModel
import onesky.assessment.feature_country.presentation.components.ProgressComponent
import onesky.assessment.feature_country.presentation.components.SubTitle
import onesky.assessment.feature_country.presentation.components.TopBar
import onesky.assessment.feature_country.presentation.utils.Screen

@Composable
fun CountryDetailScreen(
    navController: NavController, countryName: String, viewModel: CountryViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val state = viewModel.countryState.collectAsState().value

    LaunchedEffect(key1 = true){
        viewModel.getCountryDetail(countryName)
    }

    Scaffold(scaffoldState = scaffoldState,
        topBar = { TopBar(title = stringResource(id = R.string.str_country_details)) }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(it)
                .padding(start = 16.dp, end = 16.dp, top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val country = if (state is ResultData.Success)
                state.data else null

            // Text for title
            SubTitle(subTitle = countryName)

            InitInfo(
                rowList = viewModel.getRowInfo(
                    context = LocalContext.current, country
                )
            )
            ViewOnMapButton(navController = navController, countryDetail = country)
        }
        ProgressComponent(state is ResultData.Loading)
    }
    
    BackHandler {
        navController.popBackStack()
    }
}

@Composable
fun ViewOnMapButton(navController: NavController, countryDetail: Country?) {
    Button(
        onClick = {
            navController.navigate(
                route = Screen.CountryMap.passCountryName(
                    countryDetail?.latlng?.get(0)!!,
                    countryDetail.latlng[1]
                )
            )
        }, Modifier.alpha(if (countryDetail?.hasValidLatLng() == true) 1.0f else 0.0f),
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
    ) {
        Text(text = stringResource(id = R.string.str_view_on_map))
    }
}

@Composable
fun InitInfo(rowList: List<RowInfo>) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) { items(rowList) { row -> CountryInfoItem(rowInfo = row) } }
}


