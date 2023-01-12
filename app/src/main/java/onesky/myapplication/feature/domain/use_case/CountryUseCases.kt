package onesky.myapplication.feature.domain.use_case

data class CountryUseCases(
    val addCountry: AddCountry,
    val getCountries: GetCountries,
    val getCountry: GetCountry
)
