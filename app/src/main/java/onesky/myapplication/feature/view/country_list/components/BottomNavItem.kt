package onesky.myapplication.feature.view.country_list.components

import onesky.myapplication.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Home : BottomNavItem("Home", R.drawable.ic_home,"country_list")
}