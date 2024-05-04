package com.cazulabs.mylogin.logIn.data.network

import com.cazulabs.mylogin.logIn.data.network.response.LogInResponse
import retrofit2.Response
import retrofit2.http.GET

interface LogInClient {

    @GET("v3/2a203145-d253-42d2-92ab-190630e682ea")
    suspend fun doLogIn(user: String, password: String): Response<LogInResponse>

}