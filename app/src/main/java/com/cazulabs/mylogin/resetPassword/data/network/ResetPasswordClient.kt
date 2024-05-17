package com.cazulabs.mylogin.resetPassword.data.network

import com.cazulabs.mylogin.core.network.Endpoints
import com.cazulabs.mylogin.resetPassword.data.network.response.ResetPasswordResponse
import retrofit2.Response
import retrofit2.http.GET

interface ResetPasswordClient {

    @GET(Endpoints.DEFAULT)
    suspend fun onResetPasswordViaEmail(/*email: String, password: String*/): Response<ResetPasswordResponse>

    @GET(Endpoints.DEFAULT)
    suspend fun onResetPasswordViaPhone(/*phone: String, password: String*/): Response<ResetPasswordResponse>

}