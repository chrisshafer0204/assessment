package onesky.assessment.feature_country.domain.use_case

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import onesky.assessment.feature_country.domain.model.country.Country
import onesky.assessment.feature_country.domain.model.country.Name
import onesky.assessment.feature_country.domain.network.ResultData
import onesky.assessment.feature_country.domain.repository.CountryRepository
import javax.inject.Inject

class CountryUseCases @Inject constructor(
    private val countryRepository: CountryRepository
){
    suspend fun getCountryDetail(countryName: String): Flow<ResultData<List<Country>>>{
        return flow {
            emit(ResultData.Loading)
            val countryList = countryRepository.getCountryDetail(countryName)

            val resultData = if (countryList.isEmpty()) {
                ResultData.Failed()
            } else {
                val country = countryList.first()
                country.officialName = country.name?.common ?: ""
                countryRepository.insertCountryToLocal(country)
                ResultData.Success(countryList)
            }
            emit(resultData)
        }.catch {
            emit(ResultData.Failed())
        }
    }

    suspend fun getLocalCountry(): Flow<List<Country>>{
        return countryRepository.getLocalCountryList()
    }

    suspend fun getLocalCountryByName(countryName: String): Country?{
        return countryRepository.getLocalCountryDetail(countryName)
    }

}