package onesky.assessment.feature_country.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import onesky.assessment.feature_country.domain.model.country.Country
import onesky.assessment.feature_country.domain.model.country.Name

@Dao
interface CountryDao {

    // Get country List from Local DB
    @Query("SELECT * FROM country")
    fun getCountries(): Flow<List<Country>>

    //  Get country by it's name
    @Query("SELECT * FROM country WHERE commonName = :name")
    suspend fun getCountryByName(name: String): Country?

    // Insert country to Local DB
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountry(country: Country)
}