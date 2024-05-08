package com.cazulabs.mylogin.signIn.data.network

import com.cazulabs.mylogin.signIn.data.network.response.SignInResponse
import retrofit2.Response
import retrofit2.http.GET

interface SignInClient {

    @GET("v3/f763e56b-6a5b-4f6d-81c7-c7e30f6f618f")
    suspend fun doSignIn(/*username: String, email: String, phone: String, password: String*/): Response<SignInResponse>

}