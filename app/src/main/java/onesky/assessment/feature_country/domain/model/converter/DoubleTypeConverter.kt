package onesky.assessment.feature_country.domain.model.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DoubleTypeConverter {
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