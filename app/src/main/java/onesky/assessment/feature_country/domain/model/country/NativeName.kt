package onesky.assessment.feature_country.domain.model.country

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity
data class NativeName(
    val grn: Grn?,
){
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}

class NativeNameTypeConverter{
    @TypeConverter
    fun fromString(value: String) : NativeName{
        val type = object : TypeToken<NativeName>(){}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun fromNativeName(value: NativeName) : String{
        return Gson().toJson(value)
    }
}