package onesky.assessment.feature_country.presentation.components

import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun SubTitle(subTitle: String) {

    //To define subtitles on each screen
    Text(
        text = subTitle,

        // Text Style
        style = MaterialTheme.typography.titleLarge,
        color = Color.Black
    )
}
