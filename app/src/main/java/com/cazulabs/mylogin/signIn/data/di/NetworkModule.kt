package com.cazulabs.mylogin.signIn.data.di

import com.cazulabs.mylogin.signIn.data.network.SignInClient
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
    fun provideSignInClient(retrofit: Retrofit): SignInClient {
        return retrofit.create(SignInClient::class.java)
    }

}