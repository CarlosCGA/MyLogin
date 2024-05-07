package com.cazulabs.mylogin.signIn.data.network

import com.cazulabs.mylogin.signIn.data.network.response.SignInResponse
import retrofit2.Response
import retrofit2.http.GET

interface SignInClient {

    @GET("v3/2a203145-d253-42d2-92ab-190630e682ea")
    suspend fun doSignIn(/*user: String, phone: String, password: String*/): Response<SignInResponse>

}