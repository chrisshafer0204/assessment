package onesky.assessment.feature_country.presentation.country_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import onesky.assessment.feature_country.domain.model.RowInfo

@Composable
fun CountryInfoItem(rowInfo: RowInfo) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = rowInfo.title,
            style = MaterialTheme.typography.titleMedium,
        )

        Text(
            text = rowInfo.content,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}