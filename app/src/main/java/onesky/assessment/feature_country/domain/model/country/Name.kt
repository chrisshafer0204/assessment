package onesky.assessment.feature_country.domain.model.country

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity
data class Name(
    val common: String?,
    val nativeName: NativeName?,
    val official: String?
){
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}

class NameTypeConverter{

    @TypeConverter
    fun fromString(value: String) : Name{
        val type = object : TypeToken<Name>(){}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun fromName(value: Name) : String{
        return Gson().toJson(value)
    }
}