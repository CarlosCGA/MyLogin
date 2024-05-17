package com.cazulabs.mylogin.checkUser.data.network

import com.cazulabs.mylogin.checkUser.data.CheckUserResponse
import com.cazulabs.mylogin.core.network.Endpoints
import retrofit2.Response
import retrofit2.http.GET

interface CheckUserClient {

    @GET(Endpoints.DEFAULT)
    suspend fun checkUserEmail(/*email: String*/): Response<CheckUserResponse>

    @GET(Endpoints.DEFAULT)
    suspend fun checkUserPhone(/*phone: String*/): Response<CheckUserResponse>

}