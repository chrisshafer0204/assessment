package onesky.myapplication.feature.domain.use_case

import onesky.myapplication.feature.domain.model.country.Country
import onesky.myapplication.feature.domain.model.country.InvalidCountryException
import onesky.myapplication.feature.domain.repository.CountryRepository


// UseCase to add country
class AddCountry(
    private val repository: CountryRepository
) {
    @Throws(InvalidCountryException::class)
    suspend operator fun invoke(country: Country) {
        if(country.name == null) {   // Before adding country, just check if the name is null
            throw InvalidCountryException("The name of the country can't be empty.")
        }
        if(country.subregion.isBlank()) {   // Before adding country, just check if the subregion is empty
            throw InvalidCountryException("The sub-region of the country can't be empty.")
        }
        repository.insertCountry(country)
    }
}