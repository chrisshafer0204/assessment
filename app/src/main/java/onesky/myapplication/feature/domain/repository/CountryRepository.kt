package onesky.myapplication.feature.domain.repository

import kotlinx.coroutines.flow.Flow
import onesky.myapplication.feature.domain.model.country.Country

interface CountryRepository {

    fun getCountries(): Flow<List<Country>>

    suspend fun getCountryByID(id: Int): Country?

    suspend fun insertCountry(country: Country)
}