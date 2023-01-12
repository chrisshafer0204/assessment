package onesky.assessment.feature_country.domain.use_case

import onesky.assessment.feature_country.domain.model.country.Country
import onesky.assessment.feature_country.domain.repository.CountryRepository

class GetCountry (
    private val repository: CountryRepository
) {
    suspend operator fun invoke(id: Int): Country? {
        return repository.getCountryByID(id)
    }
}