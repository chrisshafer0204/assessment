package onesky.assessment.feature_country.presentation.country_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import onesky.assessment.feature_country.domain.network.ResultData
import onesky.assessment.feature_country.domain.use_case.CountryUseCases
import javax.inject.Inject

@HiltViewModel
class CountryListViewModel @Inject constructor(
    private val countryUseCases: CountryUseCases
) : ViewModel() {

    private fun getCountryList(){
        viewModelScope.launch {
            countryUseCases.getCountryList().onEach {
                when(it){
                    is ResultData.Failed ->{

                    }
                    is ResultData.Success ->{

                    }
                }
            }.collect()
        }
    }
}