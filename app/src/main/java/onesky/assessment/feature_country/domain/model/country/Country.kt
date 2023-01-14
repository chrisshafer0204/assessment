package onesky.assessment.feature_country.domain.model.country

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity
data class Country(
    val altSpellings: List<String> ,
    val area: Double,
    val capital: List<String>,
    val capitalInfo: CapitalInfo,
    val latlng: List<Double>,
    val maps: Maps,
    val name: Name?,
    val population: Int,
    val region: String,
    val subregion: String,
    val flag: String,
    var officialName : String
){

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
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
