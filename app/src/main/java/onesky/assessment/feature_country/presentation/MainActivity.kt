package onesky.assessment.feature_country.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import onesky.assessment.AppConstants.SCREEN_NAME_COUNTRY_LIST
import onesky.assessment.feature_country.presentation.country_list.CountryListScreen
import onesky.assessment.feature_country.presentation.components.Navigation
import onesky.assessment.ui.theme.AssessmentTheme
import kotlin.text.Typography

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssessmentTheme {
                 Navigation()  // Launch Navigation-  By default it will option Country List Screen
            }
        }
    }
}



