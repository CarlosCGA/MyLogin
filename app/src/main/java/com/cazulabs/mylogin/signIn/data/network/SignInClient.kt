package com.cazulabs.mylogin.signIn.data.network

import com.cazulabs.mylogin.core.network.Endpoints
import com.cazulabs.mylogin.signIn.data.network.response.SignInResponse
import retrofit2.Response
import retrofit2.http.GET

interface SignInClient {

    @GET(Endpoints.DEFAULT)
    suspend fun doSignIn(/*username: String, email: String, prefixPhone: String, phone: String, password: String*/): Response<SignInResponse>

}