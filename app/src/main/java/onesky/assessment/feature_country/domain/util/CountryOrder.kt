package onesky.assessment.feature_country.domain.util

sealed class CountryOrder(val orderType: OrderType) {
    class Name(orderType: OrderType): CountryOrder(orderType)

    fun copy(orderType: OrderType): CountryOrder {
        return when(this) {
            is Name -> Name(orderType)
        }
    }
}