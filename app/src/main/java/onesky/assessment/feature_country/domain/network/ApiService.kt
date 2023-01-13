package onesky.assessment.feature_country.domain.network

import onesky.assessment.feature_country.domain.model.country.Country
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("name/{country_name}")
    suspend fun getCountryWithName(
        @Path("country_name") countryName : String) : List<Country>
}