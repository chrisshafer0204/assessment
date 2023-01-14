package onesky.assessment.feature_country.presentation

import android.util.Log
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
class CountryViewModel @Inject constructor(
    private val countryUseCases: CountryUseCases
) : ViewModel() {

    init {
     //   getLocalCountryList()
    }

    private var _countryState = MutableStateFlow<ResultData<List<Country>>>(ResultData.Loading)
    val countryState: StateFlow<ResultData<List<Country>>>
        get() = _countryState

    fun getLocalCountryList(){
        viewModelScope.launch {
            countryUseCases.getLocalCountry().onEach {
            }.collect()
        }
    }

    fun getLocalCountryByName(countryName: String){
        viewModelScope.launch {
           val country = countryUseCases.getLocalCountryByName(countryName)
            if (country == null){

            }else{

            }
        }
    }

    // Get Country detail by it's name
    fun getCountryDetail(countryName: String) {
        viewModelScope.launch {
            countryUseCases.getCountryDetail(countryName).onEach {
                _countryState.value = it
            }.collect()
        }
    }
}