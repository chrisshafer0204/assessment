package onesky.assessment.feature_country.domain.use_case

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import onesky.assessment.feature_country.domain.model.country.Country
import onesky.assessment.feature_country.domain.repository.CountryRepository
import onesky.assessment.feature_country.domain.util.CountryOrder
import onesky.assessment.feature_country.domain.util.OrderType

class GetCountries (
    private val repository: CountryRepository
) {

    operator fun invoke(
        countryOrder: CountryOrder = CountryOrder.Name(OrderType.Ascending)
    ): Flow<List<Country>> {
        return repository.getCountries().map { countries ->
            when(countryOrder.orderType) {
                is OrderType.Ascending -> {
                    when(countryOrder) {
                        is CountryOrder.Name -> countries.sortedBy { (it.name?.official ?:"").lowercase() }
                    }
                }
                is OrderType.Descending -> {
                    when(countryOrder) {
                        is CountryOrder.Name -> countries.sortedByDescending { (it.name?.official ?:"").lowercase() }
                    }
                }
            }
        }
    }
}