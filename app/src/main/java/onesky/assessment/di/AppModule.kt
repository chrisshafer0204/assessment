package onesky.assessment.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import onesky.assessment.feature_country.data.data_source.CountryDatabase
import onesky.assessment.feature_country.data.repository.CountryRepositoryImpl
import onesky.assessment.feature_country.domain.repository.CountryRepository
import onesky.assessment.feature_country.domain.use_case.AddCountry
import onesky.assessment.feature_country.domain.use_case.CountryUseCases
import onesky.assessment.feature_country.domain.use_case.GetCountries
import onesky.assessment.feature_country.domain.use_case.GetCountry
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCountryDatabase(app: Application): CountryDatabase {
        return Room.databaseBuilder(
            app,
            CountryDatabase::class.java,
            CountryDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideCountryRepository(db: CountryDatabase): CountryRepository {
        return CountryRepositoryImpl(db.countryDao)
    }

    @Provides
    @Singleton
    fun provideCountryUseCases(repository: CountryRepository): CountryUseCases {
        return CountryUseCases(
            addCountry = AddCountry(repository),
            getCountries = GetCountries(repository),
            getCountry = GetCountry(repository),
        )
    }
}