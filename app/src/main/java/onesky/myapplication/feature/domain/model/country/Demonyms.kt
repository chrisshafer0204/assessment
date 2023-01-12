package onesky.myapplication.feature.domain.model.country

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity
data class Demonyms(
    val eng: Eng,
)  {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}

class DemonymsTypeConverter{

    @TypeConverter
    fun fromString(value: String) : Demonyms{
        val listType = object : TypeToken<Demonyms>(){}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromDemonyms(value: Demonyms) : String{
        return Gson().toJson(value)
    }
}