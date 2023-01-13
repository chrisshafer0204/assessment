package onesky.assessment.feature_country.presentation.country_list.components

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


@Composable
fun CountryListItem(countryName: String) {
    var selectedName : String = ""
    Surface(modifier = Modifier.clickable {

    }) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

        }
    }
    }
