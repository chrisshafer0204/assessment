package onesky.assessment.feature_country.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import onesky.assessment.feature_country.domain.model.country.Country
import onesky.assessment.feature_country.domain.network.ResultData
import onesky.assessment.feature_country.domain.use_case.CountryUseCases
import javax.inject.Inject

@HiltViewModel
class CountryListViewModel @Inject constructor(
    private val countryUseCases: CountryUseCases
) : ViewModel() {

    private var _countryState = MutableStateFlow<ResultData<List<Country>>>(ResultData.Loading)
    val countryState: StateFlow<ResultData<List<Country>>>
        get() = _countryState

    fun getCountryDetail(countryName: String) {
        viewModelScope.launch {
            countryUseCases.getCountryDetail(countryName).onEach {
                _countryState.value = it
            }.collect()
        }
    }
}