package onesky.assessment.feature_country.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import onesky.assessment.feature_country.presentation.country_list.CountryListScreen
import onesky.assessment.feature_country.presentation.country_list.components.BottomNavigationBar
import onesky.assessment.feature_country.presentation.country_list.components.BottomNavItem
import onesky.assessment.feature_country.presentation.country_list.components.Navigation
import onesky.assessment.ui.theme.AssessmentTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssessmentTheme {
                val navController = rememberNavController()
                CountryListScreen(navController = navController)
            }
        }
    }

}



