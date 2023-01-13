package onesky.assessment.feature_country.presentation.country_detail

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotApplyResult
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import onesky.assessment.R
import onesky.assessment.feature_country.domain.model.country.Country
import onesky.assessment.feature_country.domain.network.ResultData
import onesky.assessment.feature_country.presentation.CountryListViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CountryDetailScreen(
    countryName: String, viewModel: CountryListViewModel = hiltViewModel()
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

    LaunchedEffect(Unit) {
        viewModel.getCountryDetail(countryName)
    }

    Scaffold(
        scaffoldState = scaffoldState,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(it)
                .padding(start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Text for title
            Text(
                text = countryName ?: "",
                style = TextStyle(fontSize = 24.sp),
                fontWeight = FontWeight.Bold,
            )

            //Line for Capital
            Capital(country = getCountryDetail())

            //Line for Population
            Population(country = getCountryDetail())

            //Line for Area
            Area(country = getCountryDetail())

            //Line for Region
            Region(country = getCountryDetail())

            //Line for SubRegion
            SubRegion(country = getCountryDetail())

        }
    }
}


@Composable
fun Capital(country: Country?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(id = R.string.str_capital), fontWeight = FontWeight.Bold
        )

        Text(
            text = country?.capital?.first() ?: "",
        )
    }
}

@Composable
fun Population(country: Country?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(id = R.string.str_population), fontWeight = FontWeight.Bold
        )

        Text(text = (country?.population ?: 0).toString())
    }
}

@Composable
fun Area(country: Country?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(id = R.string.str_area), fontWeight = FontWeight.Bold
        )

        Text(text = (country?.area ?: 0.0).toString())
    }
}

@Composable
fun Region(country: Country?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(id = R.string.str_region), fontWeight = FontWeight.Bold
        )

        Text(text = (country?.region ?: ""))
    }
}

@Composable
fun SubRegion(country: Country?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(id = R.string.str_sub_region), fontWeight = FontWeight.Bold
        )

        Text(text = (country?.subregion ?: ""))
    }
}