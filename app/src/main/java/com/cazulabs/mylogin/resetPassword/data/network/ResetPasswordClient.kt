package com.cazulabs.mylogin.resetPassword.data.network

import com.cazulabs.mylogin.resetPassword.data.network.response.ResetPasswordResponse
import retrofit2.Response
import retrofit2.http.GET

interface ResetPasswordClient {

    @GET("v3/2a203145-d253-42d2-92ab-190630e682ea")
    suspend fun onResetPassword(/*email: String, password: String*/): Response<ResetPasswordResponse>

}