package onesky.assessment.feature_country.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import onesky.assessment.feature_country.presentation.country_detail.CountryDetailScreen


@Composable
fun CountryListItem(
    countryName: String,
    onClickCountry :(String) ->Unit,
) {
    Surface(
        modifier = Modifier.clickable() {
            onClickCountry(countryName)
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(text = countryName)
        }
    }
}
