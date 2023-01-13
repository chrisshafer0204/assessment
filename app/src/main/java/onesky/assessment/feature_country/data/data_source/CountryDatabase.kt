package onesky.assessment.feature_country.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import onesky.assessment.feature_country.domain.model.converter.StringTypeConverter
import onesky.assessment.feature_country.domain.model.country.*

@Database(
    entities = [
        Country::class,
        CapitalInfo::class,
        Eng::class,
        Maps::class,
        Name::class,
        NativeName::class,
        Grn::class,
               ],
    version = 2
)
@TypeConverters(
    StringTypeConverter::class,
    DoubleTypeConverter::class,
    CapitalInfoTypeConverter::class,
    EngTypeConverter::class,
    GrnTypeConverter::class,
    MapsTypeConverter::class,
    NameTypeConverter::class,
    NativeNameTypeConverter::class,
)
abstract class CountryDatabase : RoomDatabase() {
    abstract val countryDao: CountryDao

}