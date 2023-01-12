package onesky.assessment.feature_country.domain.model.country

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity
data class PostalCode(
    val format: String,
    val regex: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}

class PostalCodeTypeConverter{

    @TypeConverter
    fun fromString(value: String) : PostalCode{
        val listType = object : TypeToken<PostalCode>(){}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromPostalCode(value: PostalCode) : String{
        return Gson().toJson(value)
    }
}