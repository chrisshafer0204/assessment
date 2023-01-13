package onesky.assessment.feature_country.presentation.country_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import onesky.assessment.feature_country.domain.model.country.Country
import onesky.assessment.feature_country.domain.network.ResultData
import onesky.assessment.feature_country.domain.use_case.CountryUseCases
import javax.inject.Inject

class CountryDetailViewModel @Inject constructor(
    private val countryUseCases: CountryUseCases
) : ViewModel() {

    private var _countryLiveData = MutableLiveData<ResultData<List<Country>>>()
    val countryLiveData: LiveData<ResultData<List<Country>>>
        get() = _countryLiveData

    private fun getCountryDetail(countryName: String) {
        viewModelScope.launch {
            countryUseCases.getCountryDetail(countryName).onEach {
                    _countryLiveData.postValue(it)
            }.collect()
        }
    }

}