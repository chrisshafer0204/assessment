package onesky.assessment.feature_country.domain.use_case

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import onesky.assessment.feature_country.domain.model.country.Country
import onesky.assessment.feature_country.domain.network.ResultData
import onesky.assessment.feature_country.domain.repository.CountryRepository
import javax.inject.Inject

class CountryUseCases @Inject constructor(
    private val countryRepository: CountryRepository
){
    suspend fun getCountryList(): Flow<ResultData<List<Country>>>{
        return flow {
            emit(ResultData.Loading)
            val countryList = countryRepository.getCountryList()

            val resultData = if (countryList.isEmpty()) {
                ResultData.Failed()
            } else {
                ResultData.Success(countryList)
            }
            emit(resultData)
        }.catch {
            emit(ResultData.Failed())
        }
    }

    suspend fun getCountryDetail(countryName: String): Flow<ResultData<List<Country>>>{
        return flow {
            emit(ResultData.Loading)
            val countryList = countryRepository.getCountryDetail(countryName)

            val resultData = if (countryList.isEmpty()) {
                ResultData.Failed()
            } else {
                ResultData.Success(countryList)
            }
            emit(resultData)
        }.catch {
            emit(ResultData.Failed())
        }
    }
}