package onesky.assessment.feature_country.domain.model.country

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity
data class Eng(
    val f: String?,
    val m: String?
){
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}

class EngTypeConverter{

    @TypeConverter
    fun fromString(value: String) : Eng{
        val type = object : TypeToken<Eng>(){}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun fromEng(value: Eng) : String{
        return Gson().toJson(value)
    }
}