package onesky.assessment.feature_country.domain.model.country

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class Country(
    val altSpellings: List<String> ,
    val area: Double?,
    val latlng: List<Float>,
    val maps: Maps?,
    val name: Name?,
    val population: Int?,
    val region: String?,
    val subregion: String?,
    val flag: String?,
    var commonName : String?
){

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null

    @Ignore
    val capital: List<String?>? = null

    fun getCountryWithCommonName() : Country{
        this.commonName = name?.common ?: ""
        return this
    }
}
