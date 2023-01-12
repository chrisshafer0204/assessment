package onesky.myapplication.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import onesky.myapplication.feature.data.data_source.CountryDao
import onesky.myapplication.feature.data.data_source.CountryDatabase
import onesky.myapplication.feature.data.repository.CountryRepositoryImpl
import onesky.myapplication.feature.domain.repository.CountryRepository
import onesky.myapplication.feature.domain.use_case.AddCountry
import onesky.myapplication.feature.domain.use_case.CountryUseCases
import onesky.myapplication.feature.domain.use_case.GetCountries
import onesky.myapplication.feature.domain.use_case.GetCountry
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