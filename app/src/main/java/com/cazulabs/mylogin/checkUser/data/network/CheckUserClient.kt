package com.cazulabs.mylogin.checkUser.data.network

import com.cazulabs.mylogin.checkUser.data.CheckUserResponse
import retrofit2.Response
import retrofit2.http.GET

interface CheckUserClient {

    @GET("")
    suspend fun checkUserEmail(/*email: String*/): Response<CheckUserResponse>

    @GET("")
    suspend fun checkUserPhone(/*phone: String*/): Response<CheckUserResponse>

}