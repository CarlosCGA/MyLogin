package com.cazulabs.mylogin.checkUser.data.di

import com.cazulabs.mylogin.checkUser.data.network.CheckUserClient
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
    fun provideCheckUserClient(retrofit: Retrofit): CheckUserClient {
        return retrofit.create(CheckUserClient::class.java)
    }

}