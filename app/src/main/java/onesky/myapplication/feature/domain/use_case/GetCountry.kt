package onesky.myapplication.feature.domain.use_case

import onesky.myapplication.feature.domain.model.country.Country
import onesky.myapplication.feature.domain.repository.CountryRepository

class GetCountry (
    private val repository: CountryRepository
) {
    suspend operator fun invoke(id: Int): Country? {
        return repository.getCountryByID(id)
    }
}