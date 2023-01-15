package onesky.assessment.feature_country.presentation

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import onesky.assessment.feature_country.domain.model.RowInfo
import onesky.assessment.feature_country.domain.model.country.Country
import onesky.assessment.feature_country.domain.network.ResultData
import onesky.assessment.feature_country.domain.use_case.CountryUseCases
import onesky.assessment.feature_country.domain.utils.CountryUtils
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(
    private val countryUseCases: CountryUseCases
) : ViewModel() {


    private var _countryState = MutableStateFlow<ResultData<Country>>(ResultData.Loading)
    val countryState: StateFlow<ResultData<Country>>
        get() = _countryState

    // Get Country detail by it's name
    fun getCountryDetail(countryName: String) {
        viewModelScope.launch {

           _countryState.emit(countryUseCases.getCountryDetail(countryName))
        }
    }
    fun getRowInfo(context: Context, country: Country?): List<RowInfo> {
        val infoList = ArrayList<RowInfo>()
        for (i in 0..4) {
            infoList.add(CountryUtils.getRowInfoByTitle(context, country, i))
        }
        return infoList
    }
}