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
        Demonyms::class,
        Eng::class,
        Maps::class,
        Name::class,
        NativeName::class,
        Grn::class,
        PostalCode::class
               ],
    version = 1
)
@TypeConverters(
    StringTypeConverter::class,
    DoubleTypeConverter::class,
    CapitalInfoTypeConverter::class,
    DemonymsTypeConverter::class,
    EngTypeConverter::class,
    GrnTypeConverter::class,
    MapsTypeConverter::class,
    NameTypeConverter::class,
    NativeNameTypeConverter::class,
    PostalCodeTypeConverter::class
)
abstract class CountryDatabase : RoomDatabase() {
    abstract val countryDao: CountryDao

}