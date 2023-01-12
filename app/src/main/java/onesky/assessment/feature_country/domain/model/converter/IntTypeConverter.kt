package onesky.assessment.feature_country.domain.model.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class IntTypeConverter {
    @TypeConverter
    fun saveIntList(list: List<Int>): String? {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun getIntList(list: List<Int>): List<Int> {
        return Gson().fromJson(
            list.toString(),
            object : TypeToken<List<Int?>?>() {}.type
        )
    }
}
