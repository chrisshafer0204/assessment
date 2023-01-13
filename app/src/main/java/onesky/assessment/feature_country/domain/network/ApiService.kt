package onesky.assessment.feature_country.domain.network

import onesky.assessment.feature_country.domain.model.country.Country
import retrofit2.http.GET

interface ApiService {

    @GET("all")
    suspend fun getCountryList(): List<Country>

    @GET("{country_name}")
    suspend fun getCountryWithName(countryName : String) : List<Country>
}