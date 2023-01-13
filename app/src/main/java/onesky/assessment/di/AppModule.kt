package onesky.assessment.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import onesky.assessment.AppConstants.DB_NAME
import onesky.assessment.feature_country.data.data_source.CountryDatabase
import onesky.assessment.feature_country.domain.network.ApiService
import onesky.assessment.feature_country.domain.repository.CountryRepository
import onesky.assessment.feature_country.domain.use_case.CountryUseCases
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
            DB_NAME,
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideCountryRepository(apiService: ApiService, db: CountryDatabase): CountryRepository {
        return CountryRepository(apiService, db.countryDao)
    }

    @Provides
    @Singleton
    fun provideCountryUseCases(repository: CountryRepository): CountryUseCases {
        return CountryUseCases(
            repository
        )
    }
}