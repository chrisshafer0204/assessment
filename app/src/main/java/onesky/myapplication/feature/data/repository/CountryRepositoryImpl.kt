package onesky.myapplication.feature.data.repository

import kotlinx.coroutines.flow.Flow
import onesky.myapplication.feature.data.data_source.CountryDao
import onesky.myapplication.feature.domain.model.country.Country
import onesky.myapplication.feature.domain.repository.CountryRepository

class CountryRepositoryImpl (
    private val dao: CountryDao
) : CountryRepository {
    override fun getCountries(): Flow<List<Country>> {
        return dao.getCountries()
    }

    override suspend fun getCountryByID(id: Int): Country? {
        return dao.getCountryByID(id)
    }

    override suspend fun insertCountry(country: Country) {
        return dao.insertCountry(country)
    }
}