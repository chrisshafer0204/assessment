package onesky.assessment.feature_country.domain.model.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class StringTypeConverter {
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
