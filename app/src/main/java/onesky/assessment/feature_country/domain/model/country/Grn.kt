package onesky.assessment.feature_country.domain.model.country

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity
data class Grn(
    val common: String?,
    val official: String?
){
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}

class GrnTypeConverter{

    @TypeConverter
    fun fromString(value: String) : Grn{
        val type = object : TypeToken<Grn>(){}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun fromGrn(value: Grn) : String{
        return Gson().toJson(value)
    }
}