package onesky.assessment.feature_country.presentation.utils

const val COUNTRY_NAME_ARGUMENT_KEY = "country_name"
const val COUNTRY_LATITUDE_ARGUMENT_KEY = "latitude"
const val COUNTRY_LONGITUDE_ARGUMENT_KEY = "longitude"
sealed class Screen(val route: String){
    object CountryList : Screen(route = "countries")
    object CountryDetail : Screen(route = "country_detail_screen/{$COUNTRY_NAME_ARGUMENT_KEY}"){
        fun passCountryName(countryName: String) : String{
            return this.route.replace(oldValue =  "{$COUNTRY_NAME_ARGUMENT_KEY}", newValue = countryName)
        }
    }

    object CountryMap : Screen(route = "country_map_screen/{$COUNTRY_LATITUDE_ARGUMENT_KEY}/{$COUNTRY_LONGITUDE_ARGUMENT_KEY}"){
        fun passCountryName(latitude : Float, longitude: Float) : String{
            return this.route.replace(oldValue =  "{$COUNTRY_LATITUDE_ARGUMENT_KEY}", newValue = latitude.toString())
                .replace(oldValue =  "{$COUNTRY_LONGITUDE_ARGUMENT_KEY}", newValue = longitude.toString())
        }
    }
}
