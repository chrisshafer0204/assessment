package onesky.myapplication.feature.domain.model.country

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity
data class Grn(
    val common: String,
    val official: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}

class GrnTypeConverter{

    @TypeConverter
    fun fromString(value: String) : Grn{
        val listType = object : TypeToken<Grn>(){}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromGrn(value: Grn) : String{
        return Gson().toJson(value)
    }
}