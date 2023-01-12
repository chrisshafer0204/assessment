package onesky.myapplication.feature.domain.model.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DoubleTypeConverter {
    @TypeConverter
    fun saveDoubleList(list: List<Double>): String? {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun getDoubleList(list: List<Double>): List<Int> {
        return Gson().fromJson(
            list.toString(),
            object : TypeToken<List<Double?>?>() {}.type
        )
    }
}