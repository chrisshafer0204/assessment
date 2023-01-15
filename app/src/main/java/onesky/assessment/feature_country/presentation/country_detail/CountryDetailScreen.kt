package onesky.assessment.feature_country.presentation.country_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import onesky.assessment.AppConstants
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
    navController : NavController,
    countryName: String, viewModel: CountryViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val state by viewModel.countryState.collectAsState()

    fun getCountryDetail(): Country? {
        return when (state) {
            is ResultData.Success -> {
                (state as ResultData.Success<List<Country>>).data!![0]
            }
            else -> null
        }
    }

    viewModel.getCountryDetail(countryName)
    viewModel.getLocalCountryByName(countryName)

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(title = stringResource(id = R.string.str_country_details)) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(it)
                .padding(start = 16.dp, end = 16.dp, top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Text for title
            SubTitle(subTitle = countryName)
            InitInfo(
                rowList = viewModel.getRowInfo(
                    context = LocalContext.current,
                    getCountryDetail()
                )
            )

            Button(onClick = {
                navController.navigate(route =
                Screen.CountryMap.passCountryName(getCountryDetail()?.latlng?.get(0)!!,
                    getCountryDetail()?.latlng?.get(1)!!))
            }, shape = RectangleShape) {
                Text(text = stringResource(id = R.string.str_view_on_map))
            }
        }
        ProgressComponent(getCountryDetail() == null)
    }
}

@Composable
fun InitInfo(rowList: List<RowInfo>) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) { items(rowList) { row -> CountryInfoItem(rowInfo = row) } }
}


