package com.cazulabs.mylogin.checkUser.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CheckUserService @Inject constructor(private val checkUserClient: CheckUserClient) {

    suspend fun checkUserEmail(email: String): Boolean {
        return withContext(Dispatchers.IO) {
            val response = checkUserClient.checkUserEmail()
            response.body()?.success ?: true
        }
    }

    suspend fun checkUserPhone(phone: String): Boolean {
        return withContext(Dispatchers.IO) {
            val response = checkUserClient.checkUserPhone()
            response.body()?.success ?: true
        }
    }

}