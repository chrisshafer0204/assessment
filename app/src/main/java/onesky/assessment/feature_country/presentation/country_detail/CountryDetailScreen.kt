package onesky.assessment.feature_country.presentation.country_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import onesky.assessment.R
import onesky.assessment.feature_country.domain.model.country.Country
import onesky.assessment.feature_country.domain.network.ResultData
import onesky.assessment.feature_country.presentation.CountryViewModel
import onesky.assessment.feature_country.presentation.components.ProgressComponent
import onesky.assessment.feature_country.presentation.components.SubTitle
import onesky.assessment.feature_country.presentation.components.TopBar

@Composable
fun CountryDetailScreen(
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
            InitInfo(country = getCountryDetail())
        }
        ProgressComponent(getCountryDetail() == null)
    }
}

@Composable
fun InitInfo(country: Country?) {
    //Line for Capital
    InfoLine(
        title = stringResource(id = R.string.str_capital),
        body = country?.capital?.first() ?: ""
    )

    //Line for Population
    InfoLine(
        title = stringResource(id = R.string.str_population),
        body = (country?.population ?: 0).toString()
    )

    //Line for Area
    InfoLine(
        title = stringResource(id = R.string.str_area),
        body = (country?.area ?: 0.0).toString()
    )

    //Line for Region
    InfoLine(
        title = stringResource(id = R.string.str_region),
        body = country?.region ?: stringResource(id = R.string.str_unknown_info)
    )

    //Line for SubRegion
    InfoLine(
        title = stringResource(id = R.string.str_sub_region),
        body = (country?.subregion ?: stringResource(id = R.string.str_unknown_info))
    )
}


@Composable
fun InfoLine(title: String, body: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
        )

        Text(
            text = body,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}