package com.cazulabs.mylogin.core.di

import com.cazulabs.mylogin.logIn.data.network.LogInClient
import com.cazulabs.mylogin.signIn.data.network.SignInClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideLogInClient(retrofit: Retrofit): LogInClient {
        return retrofit.create(LogInClient::class.java)
    }

    @Singleton
    @Provides
    fun provideSignInClient(retrofit: Retrofit): SignInClient {
        return retrofit.create(SignInClient::class.java)
    }

}