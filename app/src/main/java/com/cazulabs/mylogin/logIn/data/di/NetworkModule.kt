package com.cazulabs.mylogin.logIn.data.di

import com.cazulabs.mylogin.logIn.data.network.LogInClient
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
    fun provideLogInClient(retrofit: Retrofit): LogInClient {
        return retrofit.create(LogInClient::class.java)
    }

}