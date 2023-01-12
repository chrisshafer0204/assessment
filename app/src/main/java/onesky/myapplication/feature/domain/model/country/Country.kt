package onesky.myapplication.feature.domain.model.country

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


@Entity
data class Country(
/*    val altSpellings: List<String> ,
    val area: Double,
    val borders: List<String>,
    val capital: List<String>,
    val capitalInfo: CapitalInfo,
    val continents: List<String>,
    val demonyms: Demonyms,
    val fifa: String,
    val flag: String,
    val independent: Boolean,
    val landlocked: Boolean,
    val latlng: List<Double>,
    val maps: Maps,*/
    val name: Name?,
 /*   val population: Int,
    val postalCode: PostalCode,
    val region: String,
    val startOfWeek: String,
    val status: String,
    val subregion: String,
    val timezones: List<String>,
    val tld: List<String>,
    val unMember: Boolean*/
){
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null


}

class StringTypeConverter{

    @TypeConverter
    fun fromString(value: String) : kotlin.collections.List<String>{
        val listType = object : TypeToken<kotlin.collections.List<String>>(){}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: kotlin.collections.List<String>) : String{
        return Gson().toJson(list)
    }
}

class DoubleTypeConverter{

    @TypeConverter
    fun fromString(value: String) : kotlin.collections.List<Double>{
        val listType = object : TypeToken<kotlin.collections.List<Double>>(){}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: kotlin.collections.List<Double>) : String{
        return Gson().toJson(list)
    }
}


class InvalidCountryException(message: String): Exception(message)