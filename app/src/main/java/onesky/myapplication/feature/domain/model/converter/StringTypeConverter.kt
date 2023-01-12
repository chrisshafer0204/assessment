package onesky.myapplication.feature.domain.model.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class StringTypeConverter {
    @TypeConverter
    fun saveStringList(list: List<String>): String? {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun getIntList(list: List<String>): List<String> {
        return Gson().fromJson(
            list.toString(),
            object : TypeToken<List<String?>?>() {}.type
        )
    }
}
