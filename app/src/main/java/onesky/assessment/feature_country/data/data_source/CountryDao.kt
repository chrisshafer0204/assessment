package onesky.assessment.feature_country.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import onesky.assessment.feature_country.domain.model.country.Country

@Dao
interface CountryDao {

    @Query("SELECT * FROM country")
    fun getCountries(): Flow<List<Country>>

    @Query("SELECT * FROM country WHERE name = :name")
    suspend fun getCountryByName(name: String): Country?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountry(country: Country)
}