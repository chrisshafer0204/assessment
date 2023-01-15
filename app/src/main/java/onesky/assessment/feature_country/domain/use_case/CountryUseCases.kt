package onesky.assessment.feature_country.domain.use_case

import onesky.assessment.feature_country.domain.model.country.Country
import onesky.assessment.feature_country.domain.network.ResultData
import onesky.assessment.feature_country.domain.repository.ConverterUtils
import onesky.assessment.feature_country.domain.repository.CountryRepository
import javax.inject.Inject

class CountryUseCases @Inject constructor(
    private val countryRepository: CountryRepository
) {
    suspend fun getCountryDetail(countryName: String): ResultData<Country> {
        return try {
            val countryList = countryRepository.getCountryDetail(countryName)
            val resultData = if (countryList.isEmpty()) {
                ResultData.Failed()
            } else {
                val country = countryList.first().getCountryWithCommonName()
                countryRepository.insertCountryToLocal(country)
                ResultData.Success(country)
            }
            resultData
        } catch (e: java.lang.Exception) {
            ConverterUtils.createResultData(e) {
                getLocalCountryByName(countryName)
            }
        }
    }

    private suspend fun getLocalCountryByName(countryName: String): Country? {
        return countryRepository.getLocalCountryDetail(countryName)
    }
}