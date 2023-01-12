package onesky.assessment.feature_country.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import onesky.assessment.feature_country.presentation.component.BottomNavigationBar
import onesky.assessment.feature_country.presentation.country_list.components.BottomNavItem
import onesky.assessment.feature_country.presentation.country_list.components.Navigation
import onesky.assessment.ui.theme.AssessmentTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                AssessmentTheme {
                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(
                                items = listOf(
                                    BottomNavItem(
                                        name = "Home",
                                        route = "home",
                                        icon = Icons.Default.Home
                                    ),

                                ),
                                navController = navController,
                                onItemClick = {
                                    navController.navigate(it.route)
                                }
                            )
                        }
                    ) { paddingValue ->
                        Navigation(navController = navController)
                        paddingValue
                    }
                }
        }
    }
}



