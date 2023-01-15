package onesky.assessment.feature_country.domain.model.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class FloatTypeConverter {
    @TypeConverter
    fun fromString(value: String) : List<Float>{
        val listType = object : TypeToken<List<Double>>(){}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<Float>) : String{
        return Gson().toJson(list)
    }
}