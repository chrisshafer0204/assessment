package onesky.assessment.feature_country.presentation.map

import android.content.Context
import android.graphics.Bitmap
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import android.graphics.Canvas
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.model.*
import com.google.maps.android.compose.*
import onesky.assessment.R
import onesky.assessment.feature_country.presentation.utils.VectorConverter.getBitmapFromVector

@Composable
fun CountryMapScreen(
    latitude: Float,
    longitude: Float
) {
    val countryPosition = LatLng(latitude.toDouble(), longitude.toDouble())

    val cameraPositionState: CameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(countryPosition, 8f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {

        Marker(
            state = MarkerState(position = countryPosition),
            title = "",
            snippet = "",
            icon = getBitmapFromVector(LocalContext.current, R.drawable.ic_marker)
        )
    }
}

