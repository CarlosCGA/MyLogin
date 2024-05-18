package com.cazulabs.mylogin.logIn.data.network

import com.cazulabs.mylogin.core.network.Endpoints
import com.cazulabs.mylogin.logIn.data.network.response.LogInResponse
import retrofit2.Response
import retrofit2.http.GET

interface LogInClient {

    @GET(Endpoints.DEFAULT)
    suspend fun doLogInViaEmail(/*email: String, password: String*/): Response<LogInResponse>

    @GET(Endpoints.DEFAULT)
    suspend fun doLogInViaPhone(/*phone: String, password: String*/): Response<LogInResponse>

}