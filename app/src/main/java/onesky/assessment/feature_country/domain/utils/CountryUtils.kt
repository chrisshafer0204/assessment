package onesky.assessment.feature_country.domain.utils

import android.content.Context
import onesky.assessment.R
import onesky.assessment.feature_country.domain.model.RowInfo
import onesky.assessment.feature_country.domain.model.country.Country

object CountryUtils {

    fun getRowInfoByTitle(context: Context, country: Country?, position: Int): RowInfo {

        with(context) {
            return RowInfo(
                title = getString(
                    when (position) {
                        0 -> R.string.str_capital
                        1 -> R.string.str_population
                        2 -> R.string.str_area
                        3 -> R.string.str_region
                        4 -> R.string.str_sub_region
                        else -> R.string.str_unknown_info
                    }
                ),
                content = when (position) {
                    0 -> country?.capitalNew ?: ""
                    1 -> (country?.population ?: 0).toString()
                    2 -> (country?.area ?: 0.0).toString()
                    3 -> country?.region ?: getString(R.string.str_unknown_info)
                    4 -> (country?.subregion ?: getString(R.string.str_unknown_info))
                    else -> getString(R.string.str_unknown_info)
                }
            )
        }
    }
}