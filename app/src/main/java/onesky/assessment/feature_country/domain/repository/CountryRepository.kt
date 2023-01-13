package onesky.assessment.feature_country.domain.repository

import onesky.assessment.feature_country.domain.model.country.Country
import onesky.assessment.feature_country.domain.network.ApiService
import javax.inject.Inject

class CountryRepository @Inject constructor(private val apiService: ApiService)  {

    suspend fun getCountryList(): List<Country> {
        return apiService.getCountryList()
    }

    suspend fun getCountryDetail(countryName : String) : List<Country>{
        return apiService.getCountryWithName(countryName = countryName)
    }
}