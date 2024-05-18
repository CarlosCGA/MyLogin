package com.cazulabs.mylogin.countriesInformation.data.di

import android.content.Context
import androidx.room.Room
import com.cazulabs.mylogin.countriesInformation.data.CountriesInformationDAO
import com.cazulabs.mylogin.countriesInformation.data.CountriesInformationDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideCountriesInformationDAO(countriesInformationDatabase: CountriesInformationDatabase): CountriesInformationDAO {
        return countriesInformationDatabase.getCountriesInformationDAO()
    }

    @Provides
    @Singleton
    fun provideCountriesInformationDatabase(@ApplicationContext appContext: Context): CountriesInformationDatabase  {
        return Room.databaseBuilder(
            appContext,
            CountriesInformationDatabase::class.java,
            "CountriesInformationDatabase"
        ).build()
    }

}