package onesky.assessment.feature_country.domain.model.country

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity
data class Maps(
    val googleMaps: String,
    val openStreetMaps: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}

class MapsTypeConverter{

    @TypeConverter
    fun fromString(value: String) : Maps{
        val listType = object : TypeToken<Maps>(){}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromMap(value: Maps) : String{
        return Gson().toJson(value)
    }
}