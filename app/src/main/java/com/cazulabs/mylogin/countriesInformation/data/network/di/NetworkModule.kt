package com.cazulabs.mylogin.countriesInformation.data.network.di

import com.cazulabs.mylogin.countriesInformation.data.network.CountriesInformationClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideCountriesInformationClient(retrofit: Retrofit): CountriesInformationClient {
        return retrofit.create(CountriesInformationClient::class.java)
    }

}