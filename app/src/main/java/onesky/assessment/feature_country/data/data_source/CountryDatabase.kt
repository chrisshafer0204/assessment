package onesky.assessment.feature_country.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import onesky.assessment.feature_country.domain.model.converter.FloatTypeConverter
import onesky.assessment.feature_country.domain.model.converter.StringTypeConverter
import onesky.assessment.feature_country.domain.model.country.*

@Database(
    entities = [
        Country::class,
        Eng::class,
        Maps::class,
        Name::class,
        NativeName::class,
        Grn::class,
    ],
    version = 1
)
@TypeConverters(
    StringTypeConverter::class,
    FloatTypeConverter::class,
    EngTypeConverter::class,
    GrnTypeConverter::class,
    MapsTypeConverter::class,
    NameTypeConverter::class,
    NativeNameTypeConverter::class,
)
abstract class CountryDatabase : RoomDatabase() {
    abstract val countryDao: CountryDao

}