package onesky.assessment.feature_country.presentation.country_list.components

import onesky.assessment.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Home : BottomNavItem("Home", R.drawable.ic_home,"country_list")
}