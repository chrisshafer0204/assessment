package onesky.assessment.feature_country.domain.repository

import kotlinx.coroutines.flow.Flow
import onesky.assessment.feature_country.data.data_source.CountryDao
import onesky.assessment.feature_country.domain.model.country.Country
import onesky.assessment.feature_country.domain.network.ApiService
import javax.inject.Inject

class CountryRepository @Inject constructor(
    private val apiService: ApiService,
    private val dao: CountryDao
    ) {

    suspend fun getCountryDetail(countryName: String): List<Country> {
        return apiService.getCountryWithName(countryName = countryName)
    }

    suspend fun insertCountryToLocal(country: Country){
        dao.insertCountry(country)
    }

    fun getLocalCountryList(): Flow<List<Country>>{
       return dao.getCountries()
    }

    suspend fun getLocalCountryDetail(countryName: String): Country?{
        return dao.getCountryByName(countryName)
    }

}