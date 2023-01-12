package onesky.myapplication.feature.domain.model.country

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import onesky.myapplication.feature.domain.model.converter.DoubleTypeConverter
import onesky.myapplication.feature.domain.model.converter.StringTypeConverter

@Entity
data class CapitalInfo(
    @field:TypeConverters(DoubleTypeConverter::class)
    val latlng: List<Double>
){
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}

class CapitalInfoTypeConverter{

    @TypeConverter
    fun fromString(value: String) : CapitalInfo{
        val listType = object : TypeToken<CapitalInfo>(){}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromCapitalInfo(capitalInfo: CapitalInfo) : String{
        return Gson().toJson(capitalInfo)
    }
}