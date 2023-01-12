package onesky.assessment.feature_country.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
