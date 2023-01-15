package onesky.assessment.feature_country.domain.model.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class StringTypeConverter {
    @TypeConverter
    fun fromString(value: String) : List<String?>?{
        val listType = object : TypeToken<List<String?>?>(){}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<String?>?) : String{
        return Gson().toJson(list)
    }
}
