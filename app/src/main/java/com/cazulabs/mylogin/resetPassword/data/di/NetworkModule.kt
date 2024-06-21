package com.cazulabs.mylogin.resetPassword.data.di

import com.cazulabs.mylogin.resetPassword.data.network.ResetPasswordClient
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
    fun provideResetPasswordClient(retrofit: Retrofit): ResetPasswordClient {
        return retrofit.create(ResetPasswordClient::class.java)
    }

}