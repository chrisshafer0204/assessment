package onesky.assessment.feature_country.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import dagger.hilt.android.AndroidEntryPoint
import onesky.assessment.feature_country.presentation.utils.Navigation
import onesky.assessment.ui.theme.AssessmentTheme

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



