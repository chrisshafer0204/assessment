package onesky.assessment.feature_country.presentation.country_list

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import onesky.assessment.feature_country.domain.use_case.CountryUseCases
import javax.inject.Inject

@HiltViewModel
class CountryListViewModel @Inject constructor(
    private val countryUseCases: CountryUseCases
) : ViewModel() {
}